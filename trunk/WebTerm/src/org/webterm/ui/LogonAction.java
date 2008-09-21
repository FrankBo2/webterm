package org.webterm.ui;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.webterm.core.ConstStruts;
import org.webterm.core.UserDescription;
import org.webterm.service.AuthenticationService;
import org.webterm.service.SessionService;
import org.webterm.service.forms.query.LogonRequest;

import com.opensymphony.xwork2.ActionSupport;

/**
 * log-on action
 * 
 * @author charles
 */
public class LogonAction extends ActionSupport {

	/** Class serial */
	private static final long serialVersionUID = 1L;

	/** Action : execute log-on */
	public static final String ACTION_EXECUTE = "execute"; //$NON-NLS-1$

	/** Action : execute log-off */
	public static final String ACTION_LOGOFF = "logoff"; //$NON-NLS-1$
	
	/** Logger */
	private static final Logger LOGGER = Logger.getLogger(LogonAction.class);

	/** log-on object */
	private transient final LogonRequest logon = new LogonRequest();

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
		if (ACTION_EXECUTE.equals(this.phase)) {
			final String login = StringUtils.trimToEmpty(this.logon.getLogin());
			final String pwd = this.logon.getPassword();
			if (StringUtils.isEmpty(login) || StringUtils.isEmpty(pwd)) {
				addActionError(getText("logon.error.no_login")); //$NON-NLS-1$
			} else if (AuthenticationService.getInstance().isValidUser(login, pwd)) {
				LOGGER.info("user logged in : " + this.logon.getLogin()); //$NON-NLS-1$
				final UserDescription user = new UserDescription();
				user.setLogin(login);
				SessionService.getInstance().setUserDescription(ServletActionContext.getRequest(), user);
				result = ConstStruts.TARGET_SUCCESS;
			} else {
				addActionError(getText("logon.error.invalid_user")); //$NON-NLS-1$
			}
		} else if (ACTION_LOGOFF.equals(this.phase)) {
			SessionService.getInstance().setUserDescription(ServletActionContext.getRequest(), null);
			result = ConstStruts.TARGET_LOGOFF;
		}
		return result;
	}

	/**
	 * Getter
	 * 
	 * @return the logon
	 */
	public LogonRequest getLogon() {
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
