package org.webterm.ui;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.webterm.core.ConstStruts;
import org.webterm.core.plugin.authentication.AuthenticationProvider;

import com.opensymphony.xwork2.ActionSupport;

/**
 * log-on action
 * 
 * @author charles
 */
public class LogonAction extends ActionSupport {

	/** Class serial */
	private static final long serialVersionUID = 1L;

	/** Logger */
	private static final Logger LOGGER = Logger.getLogger(LogonAction.class);

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
		String result = ConstStruts.TARGET_ERROR; // NOPMD - init
		LOGGER.info("trying : " + this.phase); //$NON-NLS-1$
		if ("execute".equals(this.phase)) { //$NON-NLS-1$
			final String login = StringUtils.trimToEmpty(this.logon.getLogin());
			final String pwd = this.logon.getPassword();
			if (StringUtils.isEmpty(login) || StringUtils.isEmpty(pwd)) {
				addActionError(getText("logon.error.no_login")); //$NON-NLS-1$
			} else if (AuthenticationProvider.getInstance().isValidUser(login, pwd)) {
				LOGGER.info("user logged in : " + this.logon.getLogin()); //$NON-NLS-1$
				result = ConstStruts.TARGET_SUCCESS;
			} else {
				addActionError(getText("logon.error.invalid_user")); //$NON-NLS-1$
			}
		}
		return result;
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
