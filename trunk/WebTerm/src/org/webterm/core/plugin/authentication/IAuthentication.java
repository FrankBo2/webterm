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
	 * Interface for password checking
	 * 
	 * @author charles
	 */
	interface IAuthenticationCheck {
		
		/**
		 * Password check method.
		 * 
		 * @param passwd User password offer.
		 * @param pwdAttr Password attribute in the database.
		 * @return TRUE if the password match.
		 */
		boolean isValidPassword(final String passwd, byte[] pwdAttr);
		
		/** 
		 * Getter
		 * 
		 * @return Password encoding method.
		 */
		String getEncodeMethod();
		
	}
	
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
