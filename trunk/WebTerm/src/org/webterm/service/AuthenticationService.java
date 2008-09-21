/**
 * 
 */
package org.webterm.service;

import org.webterm.core.plugin.authentication.IAuthentication;

/**
 * Authentication provider
 * 
 * @author charles
 */
public final class AuthenticationService {
	
	/** authentication provider */
	private transient IAuthentication authProvider = null;

	/** Unique instance. */
	private static final AuthenticationService instance = new AuthenticationService();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static AuthenticationService getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private AuthenticationService() {
		super();
	}

	/**
	 * Setter
	 * 
	 * @param authProvider Authentication provider
	 */
	public void setAuthProvider(final IAuthentication authProvider) {
		if (this.authProvider != null) {
			this.authProvider.destroy();
		}
		this.authProvider = authProvider;
		if (authProvider != null) {
			this.authProvider.init();
		}
	}
	
	
	/**
	 * Authentication method.
	 * 
	 * @param user User name.
	 * @param passwd Password.
	 * @return TRUE if the user is valid.
	 */
	public boolean isValidUser(final String user, final String passwd) {
		return (this.authProvider == null) ? false : this.authProvider.isValidUser(user, passwd);
	}
}
