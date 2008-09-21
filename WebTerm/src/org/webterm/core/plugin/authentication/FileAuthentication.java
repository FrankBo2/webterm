package org.webterm.core.plugin.authentication;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.webterm.configuration.ConfigurationReader;

/**
 * Provider for file authentication
 * 
 * @author charles
 */
public final class FileAuthentication implements IAuthentication {

	/** Logger */
	private static final Logger LOG = Logger.getLogger(FileAuthentication.class);

	/** Authentication method name */
	private static final String AUTH_METHOD = "file"; //$NON-NLS-1$

	/** Name of the configuration file in the ApplicationConfiguration.properties */
	private static final String CONFIG_FILE_NAME = "AUTHENTICATION.FILE.FILE_NAME"; //$NON-NLS-1$

	/** Use definitions */
	private transient ResourceBundle userDb = null;

	/** Unique instance. */
	private static final FileAuthentication instance = new FileAuthentication();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static FileAuthentication getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private FileAuthentication() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.authentication.IAuthentication#getAuthMethod()
	 */
	@Override
	public String getAuthMethod() {
		return AUTH_METHOD;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.authentication.IAuthentication#init()
	 */
	@Override
	public void init() {
		LOG.info("Initializing File authentication..."); //$NON-NLS-1$

		final String configFile = ConfigurationReader.getInstance().getApplicationProperty(CONFIG_FILE_NAME);
		try {
			this.userDb = ResourceBundle.getBundle(configFile);
		} catch (final MissingResourceException ex) {
			LOG.fatal(ex, ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.authentication.IAuthentication#isValidUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isValidUser(final String user, final String passwd) {
		boolean result = false; // NOPMD - init
		if (this.userDb != null) {
			try {
				result = StringUtils.trimToEmpty(this.userDb.getString(user)).equals(passwd);
			} catch (final Exception ex) {
				LOG.debug(ex, ex);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.authentication.IAuthentication#destroy()
	 */
	@Override
	public void destroy() {
		// Nothing to do
	}

}
