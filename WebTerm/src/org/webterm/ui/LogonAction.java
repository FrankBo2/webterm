package org.webterm.ui;

import org.apache.log4j.Logger;
import org.webterm.core.plugin.authentication.AuthenticationProvider;

import com.opensymphony.xwork2.Action;

/**
 * log-on action
 * 
 * @author charles
 */
public class LogonAction implements Action {

	/** Logger */
	private static final Logger LOG = Logger.getLogger(LogonAction.class);

	/** log-on object */
	private transient final LogonForm logon = new LogonForm();

	/** Authentication phase */
	private String phase;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	@Override
	public String execute() {
		if ("execute".equals(this.phase)) { //$NON-NLS-1$
			final AuthenticationProvider auth = AuthenticationProvider.getInstance();
			if (auth.isValidUser(this.logon.getLogin(), this.logon.getPassword())) {
				LOG.info("user logged in : " + this.logon.getLogin()); //$NON-NLS-1$
			}
		}
		return null;
	}

	/**
	 * Getter
	 * 
	 * @return the logon
	 */
	public LogonForm getLogon() {
		return this.logon;
	}

	/**
	 * Getter
	 * 
	 * @return the phase
	 */
	public String getPhase() {
		return this.phase;
	}

	/**
	 * Setter
	 * 
	 * @param phase the phase to set
	 */
	public void setPhase(final String phase) {
		this.phase = phase;
	}
}
