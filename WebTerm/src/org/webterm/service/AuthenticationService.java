/**
 * This file is part of WebTerm.
 *
 * WebTerm is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebTerm is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with WebTerm. If not, see <http://www.gnu.org/licenses/>.
 *
 * (C) COPYRIGHT 2008 - Charles FENDT
 */
package org.webterm.service;

import org.webterm.core.plugin.authentication.IAuthentication;

/**
 * Authentication provider
 * 
 * @author charles
 */
public final class AuthenticationService {
	
	/** authentication provider */
	private transient IAuthentication authProvider = null;

	/** Unique instance. */
	private static final AuthenticationService instance = new AuthenticationService();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static AuthenticationService getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private AuthenticationService() {
		super();
	}

	/**
	 * Setter
	 * 
	 * @param authProvider Authentication provider
	 */
	public void setAuthProvider(final IAuthentication authProvider) {
		if (this.authProvider != null) {
			this.authProvider.destroy();
		}
		this.authProvider = authProvider;
		if (authProvider != null) {
			this.authProvider.init();
		}
	}
	
	
	/**
	 * Authentication method.
	 * 
	 * @param user User name.
	 * @param passwd Password.
	 * @return TRUE if the user is valid.
	 */
	public boolean isValidUser(final String user, final String passwd) {
		return (this.authProvider == null) ? false : this.authProvider.isValidUser(user, passwd);
	}
}
