/**
 * 
 */
package com.liferay.tool.datamanipulator.datatype.site;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.PortalSessionThreadLocal;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.tool.datamanipulator.entry.BaseEntry;
import com.liferay.tool.datamanipulator.entry.EntryTypeKeys;
import com.liferay.tool.datamanipulator.entryreader.EntryTypeReader;
import com.liferay.tool.datamanipulator.entryreader.util.EntryReaderUtil;
import com.liferay.tool.datamanipulator.handler.entryhandler.model.EntryHandlerModel;
import com.liferay.tool.datamanipulator.handler.portlethandler.AbstractPortletHandler;
import com.liferay.tool.datamanipulator.handler.portlethandler.model.PortletHandlerModel;
import com.liferay.tool.datamanipulator.requestprocessor.RequestProcessor;

/**
 * @author KTibi
 *
 */
public class SiteHandler extends AbstractPortletHandler implements
		PortletHandlerModel {

	/* (non-Javadoc)
	 * @see com.liferay.tool.datamanipulator.handler.portlethandler.model.PortletHandlerModel#startErase(com.liferay.tool.datamanipulator.requestprocessor.RequestProcessor)
	 */
	@Override
	public void startErase(RequestProcessor requestProcessor)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.liferay.tool.datamanipulator.handler.portlethandler.model.PortletHandlerModel#startGenerate(com.liferay.tool.datamanipulator.requestprocessor.RequestProcessor)
	 */
	@Override
	public void startGenerate(RequestProcessor requestProcessor)
		throws PortalException, SystemException {

		int siteCount = requestProcessor.getCount(
			EntryTypeKeys.PORTAL_SITE);

		int siteDepth = requestProcessor.getDepth(
			EntryTypeKeys.PORTAL_SITE);

		int siteUpdate = requestProcessor.getUpdateLevel(
			EntryTypeKeys.PORTAL_SITE);

		int siteSubCount = requestProcessor.getSubCount(
			EntryTypeKeys.PORTAL_SITE);

		EntryTypeReader siteEntryType = EntryReaderUtil.getEntryType(
			EntryTypeKeys.PORTAL_SITE);

		BaseEntry siteEntry = new BaseEntry(siteEntryType);

		EntryHandlerModel siteHandler = new SiteEntryHandler(
			siteCount, siteUpdate, siteDepth, siteSubCount, siteEntry,
			null, requestProcessor);

		siteHandler.generateEntries((long)0);
	}

}