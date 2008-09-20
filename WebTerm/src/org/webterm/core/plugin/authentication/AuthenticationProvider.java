/**
 * 
 */
package org.webterm.core.plugin.authentication;

/**
 * Authentication provider
 * 
 * @author charles
 */
public final class AuthenticationProvider {
	
	/** authentication provider */
	private transient IAuthentication authProvider = null;

	/** Unique instance. */
	private static final AuthenticationProvider instance = new AuthenticationProvider();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static AuthenticationProvider getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private AuthenticationProvider() {
		super();
	}

	/**
	 * Setter
	 * 
	 * @param authProvider Authentication provider
	 */
	public void setAuthProvider(final IAuthentication authProvider) {
		this.authProvider = authProvider;
		this.authProvider.init();
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
