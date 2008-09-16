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
