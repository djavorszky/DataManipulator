/**
 * 
 */
package com.liferay.tool.datamanipulator.datatype.site;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.StagingLocalServiceUtil;
import com.liferay.tool.datamanipulator.entry.BaseEntry;
import com.liferay.tool.datamanipulator.entry.EntryArgs;
import com.liferay.tool.datamanipulator.entry.util.EntryUtil;
import com.liferay.tool.datamanipulator.handler.entryhandler.AbstractEntryHandler;
import com.liferay.tool.datamanipulator.handler.entryhandler.model.EntryHandlerModel;
import com.liferay.tool.datamanipulator.model.DataManipulator;
import com.liferay.tool.datamanipulator.requestprocessor.RequestProcessor;
import com.liferay.tool.datamanipulator.service.DataManipulatorLocalServiceUtil;

/**
 * @author Tibor Kovács
 *
 */
public class SiteEntryHandler extends AbstractEntryHandler implements
		EntryHandlerModel {

	/**
	 * @param count
	 * @param update
	 * @param depth
	 * @param subCount
	 * @param baseEntry
	 * @param subEntryHandler
	 * @param requestProcessor
	 */
	public SiteEntryHandler(
		int count, int update, int depth, int subCount, BaseEntry baseEntry,
		EntryHandlerModel subEntryHandler, RequestProcessor requestProcessor) {

		super(
			count, update, depth, subCount, baseEntry, subEntryHandler,
			requestProcessor);

		_stagingEnable = requestProcessor.getBoolean("staging");
	}

	/* (non-Javadoc)
	 * @see com.liferay.tool.datamanipulator.handler.entryhandler.model.EntryHandlerModel#getCreateEntryArgs(long, java.lang.String, com.liferay.tool.datamanipulator.requestprocessor.RequestProcessor)
	 */
	@Override
	public EntryArgs getCreateEntryArgs(
			long parentId, String postString, RequestProcessor requestProcessor)
		throws PortalException, SystemException {

		long groupId = requestProcessor.getGroupId();

		EntryArgs args = new EntryArgs(requestProcessor);

		args.setParameter("parentGroupId", parentId);
		args.setParameter("className", Group.class.getName());
		args.setParameter("classPK", groupId);
		args.setParameter("liveGroupId", GroupConstants.DEFAULT_LIVE_GROUP_ID);
		args.setParameter("name", "Test Site" + postString + " Name");
		args.setParameter(
			"description", "Test Site" + postString + " Description");

		args.setParameter("type", requestProcessor.getInteger("type"));
		args.setParameter("manualMembership", true);
		args.setParameter(
			"membershipRestriction",
			GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION);

		args.setParameter("site", true);
		args.setParameter("active", true);

		return args;
	}

	/* (non-Javadoc)
	 * @see com.liferay.tool.datamanipulator.handler.entryhandler.model.EntryHandlerModel#getDataManipulatorFromObject(java.lang.Object)
	 */
	@Override
	public DataManipulator getDataManipulatorFromObject(Object createdEntry)
		throws PortalException, SystemException {

		Group group = (Group)createdEntry;

		if (_stagingEnable) {
			long userId = group.getCreatorUserId();

			StagingLocalServiceUtil.enableLocalStaging(
				userId, group, false, false, EntryUtil.getNewServiceContext(
					group.getGroupId(), userId));
		}

		return DataManipulatorLocalServiceUtil.addDataManipulator(
			group.getGroupId(), group.getClassName(), group.getClassPK());
	}

	/* (non-Javadoc)
	 * @see com.liferay.tool.datamanipulator.handler.entryhandler.model.EntryHandlerModel#getUpdateEntryArgs(long, java.lang.String, com.liferay.tool.datamanipulator.requestprocessor.RequestProcessor)
	 */
	@Override
	public EntryArgs getUpdateEntryArgs(
			long entryId, String postString, RequestProcessor requestProcessor)
		throws PortalException, SystemException {

		Group group = GroupLocalServiceUtil.getGroup(entryId);


		EntryArgs args = new EntryArgs(requestProcessor);

		args.setParameter("groupId", entryId);
		args.setParameter("parentGroupId", group.getParentGroupId());
		args.setParameter(
			"name", EntryUtil.getEditString(group.getName(), postString));

		args.setParameter(
			"description",
			EntryUtil.getEditString(group.getDescription(), postString));

		args.setParameter("type", requestProcessor.getInteger("type"));
		args.setParameter("manualMembership", group.getManualMembership());
		args.setParameter(
			"membershipRestriction", group.getMembershipRestriction());

		args.setParameter("active", group.getActive());

		return args;
	}

	boolean _stagingEnable;

}