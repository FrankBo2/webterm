package org.webterm.configuration;

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

	/** Navigator title */
	public static final String APPLICATION_TITLE;

	static {
		final ConfigurationReader conf = ConfigurationReader.getInstance();
		AUTHENTICATION_METHODE = conf.getApplicationProperty("AUTHENTICATION.METHODE"); //$NON-NLS-1$
		APPLICATION_TITLE = conf.getApplicationProperty("APPLICATION_TITLE"); //$NON-NLS-1$
	}
}
