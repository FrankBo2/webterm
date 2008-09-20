package org.webterm.core.configuration;

import org.webterm.core.ConstString;

/**
 * Configuration reader
 * 
 * @author charles
 */
public final class ConstConfiguration {

	/**
	 * Constructor
	 */
	private ConstConfiguration() {
		super();
	}
	
	/** Declare the authentication method */
	public static final String AUTHENTICATION_METHODE;
	
	static{
		AUTHENTICATION_METHODE = ConstString.EMPTY;
	}
}
