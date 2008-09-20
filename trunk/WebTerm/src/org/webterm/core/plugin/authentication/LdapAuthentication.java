/**
 * 
 */
package org.webterm.core.plugin.authentication;

import org.apache.log4j.Logger;

/**
 * Provider for LDAP Authentication
 * 
 * @author charles
 */
public final class LdapAuthentication implements IAuthentication {

	/** Logger */
	private static final Logger LOG = Logger.getLogger(LdapAuthentication.class);

	/** Authentication method name */
	private static final String AUTH_METHOD = "LDAP"; //$NON-NLS-1$

	/** Unique instance. */
	private static final LdapAuthentication instance = new LdapAuthentication();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static LdapAuthentication getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private LdapAuthentication() {
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
		LOG.info("Initializing LDAP authentication..."); //$NON-NLS-1$

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
