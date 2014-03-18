package com.liferay.tool.datamanipulator.datatype.custom;

import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.tool.datamanipulator.handler.portlethandler.AbstractPortletHandler;
import com.liferay.tool.datamanipulator.handler.portlethandler.model.PortletHandlerModel;
import com.liferay.tool.datamanipulator.requestprocessor.RequestProcessor;

public class CustomRoleHandler extends AbstractPortletHandler implements
		PortletHandlerModel {

	@Override
	public void startErase(RequestProcessor requestProcessor)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startGenerate(RequestProcessor requestProcessor)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub

		int numberOfRoles = 0;

		String baseName = "GeneratedRole_";

		long userId = requestProcessor.getUserId();
		long companyId = requestProcessor.getCompanyId();

		Map<Locale, String> titleMap = null;
		Map<Locale, String> descriptionMap = null;

		int type = RoleConstants.TYPE_REGULAR;

		for (int i = 0; i < numberOfRoles; i++) {
			String name = baseName + i;

			RoleLocalServiceUtil.addRole(userId, companyId, name, titleMap, 
					descriptionMap, type);

		}

	}

}
