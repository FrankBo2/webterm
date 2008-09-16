package org.webterm.service;

/**
 * Abstract structure for service query.
 * 
 * @author charles
 */
public abstract class AbstractServiceRequest { // NOPMD - no abstract methode

	/** login of the user request */
	private String userName;

	/** password of the user */
	private String userPassword;

	/**
	 * Getter
	 * 
	 * @return the userName
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * Setter
	 * 
	 * @param userName the userName to set
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * Getter
	 * 
	 * @return the password
	 */
	public String getUserPassword() {
		return this.userPassword;
	}

	/**
	 * Setter
	 * 
	 * @param userPassword the password to set
	 */
	public void setUserPassword(final String userPassword) {
		this.userPassword = userPassword;
	}
}
