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
 * Const class for user messages.
 * 
 * @author charles
 */
public final class ConstMessages {

	/**
	 * Constructor
	 */
	private ConstMessages() {
		super();
	}

	/** Confirm message : the process is created */
	public final static String OK_AUTHENTICATED = "Login/Password is correct."; //$NON-NLS-1$ //NOPMD - Potentialy long variable name

	/** Confirm message : the process is created */
	public final static String OK_CREATED = "Process created."; //$NON-NLS-1$ //NOPMD - Potentialy long variable name

	/** Confirm message : generic - no error */
	public final static String OK_GENERIC = "No error."; //$NON-NLS-1$ //NOPMD - Potentialy long variable name

	/** Error message : no such process */
	public final static String ERR_NO_PROCESS = "Parameter 'pid' is not a valid pid..."; //$NON-NLS-1$ //NOPMD - Potentialy long variable name

	/** Error message : parameter PID is needed */
	public final static String ERR_NO_PARAMETER_PID = "Parameter 'pid' needed..."; //$NON-NLS-1$ //NOPMD - Potentialy long variable name

	/** Error message : parameter PID is needed */
	public final static String ERR_NO_PARAMETER_USR_PWD = "Parameters 'userName' and 'userPassword' needed..."; //$NON-NLS-1$ //NOPMD - Potentialy long variable name

	/** Error message : the process asked is not yours */
	public final static String ERR_CONN_NOT_YOURS = "The process is not yours..."; //$NON-NLS-1$ //NOPMD - Potentialy long variable name

	/** Error message : the term type is not supported */
	public final static String ERR_UNSUPPORTED_TYPE = "Unsupported type"; //$NON-NLS-1$ //NOPMD - Potentialy long variable name

	/** Error message : the term type is not supported */
	public final static String ERR_BAD_AUTH = "Invalid login/password..."; //$NON-NLS-1$ //NOPMD - Potentialy long variable name
}
