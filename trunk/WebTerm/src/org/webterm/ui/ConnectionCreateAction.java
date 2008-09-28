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

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.webterm.core.ConstString;
import org.webterm.core.ConstStruts;
import org.webterm.core.UserDescription;
import org.webterm.service.ConnectionManagementService;
import org.webterm.service.SessionService;
import org.webterm.service.forms.AbstractServiceResult.Status;
import org.webterm.service.forms.query.CreateConnectionRequest;
import org.webterm.service.forms.result.SimpleConnectionResult;
import org.webterm.term.TermFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action for connection creation
 * 
 * @author charles
 */
public final class ConnectionCreateAction extends ActionSupport {

	/** Class serial */
	private static final long serialVersionUID = 1L;

	/** True if the initialization screen is required */
	private String init = ConstString.EMPTY;
	
	/** request form */
	transient private final CreateConnectionRequest form = new CreateConnectionRequest();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	@Override
	public String execute() {
		final String result;
		final UserDescription user = SessionService.getInstance().getUserDescription(ServletActionContext.getRequest());
		if(user == null) {
			result = null;
		} else {
			if (StringUtils.isNotEmpty(this.init)) {
				result = ConstStruts.TARGET_ERROR;
			} else {
				//set default server port
				if (this.form.getServerPort() < 1) {
					this.form.setServerPort(23);
				}
				//set user description
				this.form.setLogin(user.getLogin());
				//open connection
				final SimpleConnectionResult results = new SimpleConnectionResult();
				ConnectionManagementService.getInstance().createTerm(this.form, results);
				if (results.getStatus() == Status.OK) {
					results.getProcess().openConnection();
				}
				result = ConstStruts.TARGET_SUCCESS;			
			}
		}
		return result;
	}

	/**
	 * Getter
	 * 
	 * @return the initialization string
	 */
	public String getInit() {
		return this.init;
	}

	/**
	 * Setter
	 * 
	 * @param init the initialization to set
	 */
	public void setInit(final String init) {
		this.init = init;
	}
	
	/**
	 * Getter
	 * 
	 * @return Form
	 */
	public CreateConnectionRequest getForm() {
		return this.form;
	}
	
	/**
	 * Getter
	 * 
	 * @return supported terminal type list
	 */
	public Set<String> getTermTypeList() {
		return TermFactory.getInstance().getTermType();
	}
	
}
