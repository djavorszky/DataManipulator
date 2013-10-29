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
import com.liferay.tool.datamanipulator.datatype.blogs.BlogsHandler;
import com.liferay.tool.datamanipulator.datatype.bookmarks.BookmarksHandler;
import com.liferay.tool.datamanipulator.datatype.calendar.CalendarHandler;
import com.liferay.tool.datamanipulator.datatype.categories.CategoriesHandler;
import com.liferay.tool.datamanipulator.datatype.documentsandmedia.DocumentsAndMediaHandler;
import com.liferay.tool.datamanipulator.datatype.journal.JournalHandler;
import com.liferay.tool.datamanipulator.datatype.layout.LayoutHandler;
import com.liferay.tool.datamanipulator.datatype.messageboards.MessageBoardsHandler;
import com.liferay.tool.datamanipulator.datatype.organization.OrganizationHandler;
import com.liferay.tool.datamanipulator.datatype.site.SiteHandler;
import com.liferay.tool.datamanipulator.datatype.team.TeamHandler;
import com.liferay.tool.datamanipulator.datatype.user.UserHandler;
import com.liferay.tool.datamanipulator.datatype.wiki.WikiHandler;
import com.liferay.tool.datamanipulator.entry.EntryTypeKeys;
import com.liferay.tool.datamanipulator.handler.portlethandler.model.PortletHandlerModel;

/**
 * @author Tibor Kov�cs
 *
 */
public final class PortletHandlerFactory {

	public static PortletHandlerModel getHandlerInstance(String entryTypeKey)
		throws PortalException, SystemException {

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_ASSET_CATEGORIES)) {
			return new CategoriesHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_BLOGS)) {
			return new BlogsHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_BOOKMARKS)) {
			return new BookmarksHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_CALENDAR)) {
			return new CalendarHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_DOCUMENTS_AND_MEDIA)) {
			return new DocumentsAndMediaHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_JOURNAL)) {
			return new JournalHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_LAYOUT)) {
			return new LayoutHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_MESSAGE_BOARDS)) {
			return new MessageBoardsHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.GENERAL_WIKI)) {
			return new WikiHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.PORTAL_ORGANIZATION)) {
			return new OrganizationHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.PORTAL_SITE)) {
			return new SiteHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.PORTAL_TEAM)) {
			return new TeamHandler();
		}

		if (entryTypeKey.equals(EntryTypeKeys.PORTAL_USER)) {
			return new UserHandler();
		}

		return null;
	}

}