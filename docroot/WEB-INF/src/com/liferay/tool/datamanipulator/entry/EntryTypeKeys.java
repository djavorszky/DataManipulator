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

package com.liferay.tool.datamanipulator.entry;

import java.util.ArrayList;

/**
 * @author Tibor Kov�cs
 *
 */
public class EntryTypeKeys {
	//Lists and base names

	public static final String ENTRY_TYPE_GENERAL = "general-entry-type";

	public static final ArrayList<String> ENTRY_TYPE_GENERAL_LIST =
		_generalEntryTypes();

	public static final String ENTRY_TYPE_PLUGIN = "plugin-entry-type";

	public static final ArrayList<String> ENTRY_TYPE_PLUGIN_LIST =
		_pluginEntryTypes();

	public static final String ENTRY_TYPE_PORTAL = "portal-entry-type";

	public static final ArrayList<String> ENTRY_TYPE_PORTAL_LIST =
		_portalEntryTypes();

	// General Entry types

	//Plugin Entry types

	//Poral Entry types

	//Private methods for declare the DataTypes location

	private static ArrayList<String> _generalEntryTypes() {
		ArrayList<String> types = new ArrayList<String>();

		return types;
	}

	private static ArrayList<String> _pluginEntryTypes() {
		ArrayList<String> types = new ArrayList<String>();

		return types;
	}

	private static ArrayList<String> _portalEntryTypes() {
		ArrayList<String> types = new ArrayList<String>();

		return types;
	}

}