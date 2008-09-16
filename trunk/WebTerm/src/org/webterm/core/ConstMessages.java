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
	public final static String CONNECTION_NOT_YOURS = "The process '$pid' is not yours..."; //$NON-NLS-1$
}
