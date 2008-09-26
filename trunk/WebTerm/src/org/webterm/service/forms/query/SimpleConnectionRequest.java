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
