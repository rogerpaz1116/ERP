/*
 * Copyright 2013 SIB Visions GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.sibvisions.apps.demoerp;

import javax.rad.server.SessionContext;

import com.sibvisions.apps.server.object.DBWorkScreenAccess;
import com.sibvisions.apps.server.object.IWorkScreenAccess;
import com.sibvisions.rad.persist.jdbc.DBAccess;
import com.sibvisions.rad.persist.jdbc.DBCredentials;
import com.sibvisions.rad.server.security.DBSecurityManager;

/**
 * The Session management for DemoERP.
 */
public class Session extends Application
{
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// User-defined methods
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Gets the database access object. If the object is not instantiated, then
	 * it is instantiated.
	 * 
	 * @return the datbase access object
	 * @throws Exception if an exception occures during object instantiation
	 */
	public DBAccess getDBAccess() throws Exception
	{
		DBAccess dba = (DBAccess)get("dBAccess");

		if (dba == null)
		{
			DBCredentials dbcred = DBSecurityManager.getCredentials(SessionContext.getCurrentSessionConfig());

			// no credentials -> no database access possible (should not happen,
			// only if configuration is not finished)
			if (dbcred != null)
			{
				dba = DBAccess.getDBAccess(DBSecurityManager.getCredentials(SessionContext.getCurrentSessionConfig()));
				dba.open();

				put("dBAccess", dba);
			}
		}

		return dba;
	}

	/**
	 * Gets the work-screen access object. If the object is not instantiated,
	 * then it is instantiated.
	 * 
	 * @return the work-screen access object
	 * @throws Exception if an exception occures during object instantiation
	 */
	public IWorkScreenAccess getWorkScreenAccess() throws Exception
	{
		// interface cast: allows injection
		IWorkScreenAccess wsac = (IWorkScreenAccess)get("workScreenAccess");

		if (wsac == null)
		{
			DBWorkScreenAccess dbwsac = new DBWorkScreenAccess();
			dbwsac.setDBDataSource(getDBAccess());

			wsac = dbwsac;

			put("workScreenAccess", dbwsac);
		}

		return wsac;
	}

} // Session
