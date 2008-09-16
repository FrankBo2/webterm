package org.webterm.mmi;

/**
 * Form for the logon action.
 * 
 * @author charles
 */
public class LogonForm {

	/** login of the user */
	private String login;
	
	/** password of the user */
	private String password;

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

	/**
	 * Getter
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Setter 
	 * 
	 * @param password the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
}
