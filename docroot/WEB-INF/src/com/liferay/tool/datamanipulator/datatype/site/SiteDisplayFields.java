package com.liferay.tool.datamanipulator.datatype.site;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.model.GroupConstants;
import com.liferay.tool.datamanipulator.displayfield.DisplayFields;
import com.liferay.tool.datamanipulator.displayfield.Field;
import com.liferay.tool.datamanipulator.entry.EntryTypeKeys;

public class SiteDisplayFields {
	public static List<Field> getDisplayFields() throws SystemException {
		List<KeyValuePair> siteTypes = new ArrayList<KeyValuePair>();

		siteTypes.add(
			new KeyValuePair(
				GroupConstants.TYPE_SITE_OPEN_LABEL,
				String.valueOf(GroupConstants.TYPE_SITE_OPEN)));

		siteTypes.add(
			new KeyValuePair(
				GroupConstants.TYPE_SITE_PRIVATE_LABEL,
				String.valueOf(GroupConstants.TYPE_SITE_PRIVATE)));

		siteTypes.add(
			new KeyValuePair(
				GroupConstants.TYPE_SITE_RESTRICTED_LABEL,
				String.valueOf(GroupConstants.TYPE_SITE_RESTRICTED)));

		DisplayFields fields = new DisplayFields();

		fields.addUserMultiSelect();
		fields.addSeparator();

		fields.addCount(EntryTypeKeys.PORTAL_SITE);
		fields.addUpdateLevel(EntryTypeKeys.PORTAL_SITE);
		fields.addDepth(EntryTypeKeys.PORTAL_SITE);
		fields.addSubCount(EntryTypeKeys.PORTAL_SITE);
		fields.addSeparator();

		fields.addSelectList("type", siteTypes);
		fields.addCheckbox("staging");
		fields.addSeparator();

		return fields.getDisplayFields();
	}

}