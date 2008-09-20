package org.webterm.ui;

import com.opensymphony.xwork2.Action;

/**
 * log-on action
 * 
 * @author charles
 */
public class LogonAction implements Action {

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
