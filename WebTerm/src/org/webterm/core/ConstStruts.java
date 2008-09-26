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
package org.webterm.core;

/**
 * Constant definition for struts target.
 * 
 * @author charles
 */
public final class ConstStruts {

	/**
	 * Constructor
	 */
	private ConstStruts() {
		super();
	}
	
	/** Declare the error target */
	public static final String TARGET_ERROR = "ERROR"; //$NON-NLS-1$

	/** Declare the success target */
	public static final String TARGET_SUCCESS = "SUCCESS";//$NON-NLS-1$

	/** Session attribute name for user description */
	public static final String SESSION_USER_DESC = UserDescription.class.getName();

	/** Declare the log-off target */
	public static final String TARGET_LOGOFF = "LOGOFF"; //$NON-NLS-1$
}
