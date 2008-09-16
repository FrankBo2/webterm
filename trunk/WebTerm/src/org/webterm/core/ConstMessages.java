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
	
	/** Error message : no such process */
	public final static String NO_PROCESS = "Parameter 'pid' is not a valid pid..."; //$NON-NLS-1$
	
	/** Error message : parameter PID is needed */
	public final static String NO_PARAMETER_PID = "Parameter 'pid' needed..."; //$NON-NLS-1$
	
	/** Error message : the process asked is not yours */
	public final static String CONN_NOT_YOURS = "The process is not yours..."; //$NON-NLS-1$
	
	/** Error message : the term type is not supported */
	public final static String ERR_UNSUPPORTED_TYPE = "Unsupported type"; //$NON-NLS-1$
}
