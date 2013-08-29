/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.tool.datamanipulator.datatype;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.tool.datamanipulator.datatype.blogs.BlogsDisplayFields;
import com.liferay.tool.datamanipulator.datatype.bookmarks.BookmarksDisplayFields;
import com.liferay.tool.datamanipulator.datatype.calendar.CalendarDisplayFields;
import com.liferay.tool.datamanipulator.datatype.categories.CategoriesDisplayFields;
import com.liferay.tool.datamanipulator.datatype.documentsandmedia.DocumentsAndMediaDisplayFields;
import com.liferay.tool.datamanipulator.displayfield.Field;
import com.liferay.tool.datamanipulator.entry.EntryTypeKeys;

import java.util.List;

/**
 * @author Tibor Kov�cs
 *
 */
public final class EntryDisplayFieldsFactory {

	public static List<Field> getDisplayFields(String entryTypeKey)
		throws PortalException, SystemException {

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_ASSET_CATEGORIES)) {
			return CategoriesDisplayFields.getDisplayFields();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_BLOGS)) {
			return BlogsDisplayFields.getDisplayFields();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_BOOKMARKS)) {
			return BookmarksDisplayFields.getDisplayFields();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_CALENDAR)) {
			return CalendarDisplayFields.getDisplayFields();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_DOCUMENTS_AND_MEDIA)) {
			return DocumentsAndMediaDisplayFields.getDisplayFields();
		}

		return null;
	}

}