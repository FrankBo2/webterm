package org.webterm.ui;

import org.apache.struts2.ServletActionContext;
import org.webterm.core.ConstStruts;
import org.webterm.core.UserDescription;
import org.webterm.service.ConnectionManagementService;
import org.webterm.service.SessionService;
import org.webterm.service.forms.result.ConnectionListResult;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action to ask for the list of connection associated with the current user.
 * 
 * @author charles
 */
public class ConnectionListAction extends ActionSupport {

	/** Class serial */
	private static final long serialVersionUID = 1L;

	/** request result */
	private transient final ConnectionListResult result = new ConnectionListResult();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	@Override
	public String execute() {
		final UserDescription user = SessionService.getInstance().getUserDescription(ServletActionContext.getRequest());
		ConnectionManagementService.getInstance().getConnexionList(user, this.result);
		return ConstStruts.TARGET_SUCCESS;
	}

	/**
	 * @return the connections
	 */
	public ConnectionListResult getResult() {
		return this.result;
	}
}
