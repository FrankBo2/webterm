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
package org.webterm.service.forms.query;

import org.webterm.service.forms.AbstractServiceRequest;

/**
 * Form for the log-on action.
 * 
 * @author charles
 */
public class LogonRequest extends AbstractServiceRequest {
	
	/** password of the user */
	private String password;

	/**
	 * Getter
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Setter 
	 * 
	 * @param password the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
}
