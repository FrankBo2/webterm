package org.webterm.service.forms;

import org.webterm.service.AbstractServiceRequest;

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
