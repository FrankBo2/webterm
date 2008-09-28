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
package org.webterm.service.forms.result;

import org.webterm.connections.ConnectionDescription;
import org.webterm.service.forms.AbstractServiceResult;

/**
 * Simple result form for process request.
 * 
 * @author charles
 */
public class SimpleConnectionResult extends AbstractServiceResult {

	/** requested process */
	private ConnectionDescription process;

	/**
	 * Getter
	 * 
	 * @return the process
	 */
	public ConnectionDescription getProcess() {
		return this.process;
	}

	/**
	 * Setter
	 * 
	 * @param process the process to set
	 */
	public void setProcess(final ConnectionDescription process) {
		this.process = process;
	}

}
