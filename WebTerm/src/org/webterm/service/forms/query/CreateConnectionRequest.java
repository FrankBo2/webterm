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
 * Request for new connection.
 * 
 * @author charles
 */
public class CreateConnectionRequest extends AbstractServiceRequest {

	/** Type of terminal */
	private String type;

	/** Server where to open the connection */
	private String serverName;

	/** port on which open the connection */
	private int serverPort;

	/**
	 * Getter
	 * 
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Setter
	 * 
	 * @param type the type to set
	 */
	public void setType(final String type) {
		this.type = type;
	}

	/**
	 * Getter
	 * 
	 * @return the serverName
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * Setter
	 * 
	 * @param serverName the serverName to set
	 */
	public void setServerName(final String serverName) {
		this.serverName = serverName;
	}

	/**
	 * Getter
	 * 
	 * @return the serverPort
	 */
	public int getServerPort() {
		return this.serverPort;
	}

	/**
	 * Setter
	 * 
	 * @param serverPort the serverPort to set
	 */
	public void setServerPort(final int serverPort) {
		this.serverPort = serverPort;
	}
}
