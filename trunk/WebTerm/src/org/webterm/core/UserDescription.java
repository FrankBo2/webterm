/**
 * 
 */
package org.webterm.core;

/**
 * Class for User description in the session
 * 
 * @author charles
 */
public final class UserDescription {

	/** Login of the user */
	private String login;

	/**
	 * Getter
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Setter
	 * 
	 * @param login the login to set
	 */
	public void setLogin(final String login) {
		this.login = login;
	}
}
