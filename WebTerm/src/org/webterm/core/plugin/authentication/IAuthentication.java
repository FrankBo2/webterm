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
package org.webterm.core.plugin.authentication;

/**
 * Interface for user authentication.
 * 
 * @author charles
 */
public interface IAuthentication {

	/**
	 * Interface for password checking
	 * 
	 * @author charles
	 */
	interface IAuthenticationCheck {
		
		/**
		 * Password check method.
		 * 
		 * @param passwd User password offer.
		 * @param pwdAttr Password attribute in the database.
		 * @return TRUE if the password match.
		 */
		boolean isValidPassword(final String passwd, byte[] pwdAttr);
		
		/** 
		 * Getter
		 * 
		 * @return Password encoding method.
		 */
		String getEncodeMethod();
		
	}
	
	/** 
	 * Getter
	 * 
	 * @return Authentication method name as describe in the configuration file.
	 */
	String getAuthMethod();
	
	/**
	 * Initialization method for authentication provider
	 */
	void init();
	
	/**
	 * Destruction method.
	 */
	void destroy();
	
	/**
	 * Authentication method.
	 * 
	 * @param user User name.
	 * @param passwd Password.
	 * @return TRUE if the user is valid.
	 */
	boolean isValidUser(final String user, final String passwd);
}
