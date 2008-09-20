/**
 * 
 */
package org.webterm.core.plugin.authentication;

/**
 * Interface for user authentication.
 * 
 * @author charles
 */
public interface IAuthentication {

	/** 
	 * Getter
	 * 
	 * @return Authentication method name as describe in the configuration file.
	 */
	String getAuthMethod();
	
	/**
	 * Initialization method for authentication provider
	 */
	void init();
	
	/**
	 * Authentication method.
	 * 
	 * @param user User name.
	 * @param passwd Password.
	 * @return TRUE if the user is valid.
	 */
	boolean isValidUser(final String user, final String passwd);
}
