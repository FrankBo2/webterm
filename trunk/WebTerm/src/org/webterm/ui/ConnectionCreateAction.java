/**
 * 
 */
package org.webterm.ui;

import org.webterm.core.ConstStruts;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action for connection creation
 * 
 * @author charles
 */
public final class ConnectionCreateAction extends ActionSupport {

	/** Class serial */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	@Override
	public String execute() {
		return ConstStruts.TARGET_SUCCESS;
	}
}
