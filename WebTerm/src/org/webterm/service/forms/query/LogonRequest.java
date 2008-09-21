package org.webterm.service.forms.query;

import org.webterm.service.forms.AbstractServiceRequest;

/**
 * Form for the log-on action.
 * 
 * @author charles
 */
public class LogonRequest extends AbstractServiceRequest {
	
	/** password of the user */
	private String password;

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
