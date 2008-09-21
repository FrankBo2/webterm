package org.webterm.service.forms;

/**
 * Abstract structure for service query.
 * 
 * @author charles
 */
public abstract class AbstractServiceRequest { // NOPMD - no abstract methode

	/** login of the user request */
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
