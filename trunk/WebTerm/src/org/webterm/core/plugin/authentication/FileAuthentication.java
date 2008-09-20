/**
 * 
 */
package org.webterm.core.plugin.authentication;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Provider for file authentication
 * 
 * @author charles
 */
public final class FileAuthentication implements IAuthentication {

	/** Logger */
	private static final Logger LOG = Logger.getLogger(FileAuthentication.class);

	/** Authentication method name */
	private static final String AUTH_METHOD = "FILE"; //$NON-NLS-1$

	/** Use definitions */
	private List<?> userDefinition;

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

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.authentication.IAuthentication#isValidUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isValidUser(final String user, final String passwd) {
		// TODO Auto-generated method stub
		return false;
	}
}
