/**
 * This file is part of WebTerm.
 *
 * WebTerm is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebTerm is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with WebTerm. If not, see <http://www.gnu.org/licenses/>.
 *
 * (C) COPYRIGHT 2008 - Charles FENDT
 */
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
