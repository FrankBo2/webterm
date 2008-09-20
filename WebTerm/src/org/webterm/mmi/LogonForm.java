package org.webterm.mmi;

import org.apache.struts.action.ActionForm;

/**
 * Form for the log-on action.
 * 
 * @author charles
 */
public class LogonForm extends ActionForm {

	/** Class serial number */
	private static final long serialVersionUID = 1L;

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
