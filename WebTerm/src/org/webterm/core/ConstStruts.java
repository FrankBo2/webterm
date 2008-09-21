/**
 * 
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
}
