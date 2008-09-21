package org.webterm.service.forms.query;

import org.webterm.service.forms.AbstractServiceRequest;

/**
 * Form for simple connection request
 * 
 * @author charles
 */
public class SimpleConnectionRequest extends AbstractServiceRequest {

	/** PID of the connection */
	private long pid;

	/**
	 * Getter
	 * 
	 * @return the pid
	 */
	public long getPid() {
		return this.pid;
	}

	/**
	 * Setter
	 * 
	 * @param pid the pid to set
	 */
	public void setPid(final long pid) {
		this.pid = pid;
	}
}
