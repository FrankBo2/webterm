package org.webterm.core.configuration;

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

	static {
		AUTHENTICATION_METHODE = ConfigurationReader.getInstance().getApplicationProperty("AUTHENTICATION.METHODE"); //$NON-NLS-1$
	}
}
