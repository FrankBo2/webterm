package org.webterm.connections;

import java.net.Socket;

/**
 * Class for connection description
 * 
 * @author charles
 */
public final class ConnectionDescription {

	/** Name of the server. */
	private String serverName;

	/** Port of the connection */
	private int port;

	/** Name of the terminal */
	private String termName;
	
	/** status for the connection. */
	private transient EnumConnectionStatus connectionStatus = EnumConnectionStatus.NOT_CREATED;
	
	/** Socket for the host connection. */
	private transient Socket socket;

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
	 * @param serverName
	 *            the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	/**
	 * Getter
	 * 
	 * @return the port
	 */
	public int getPort() {
		return this.port;
	}

	/**
	 * Setter
	 * 
	 * @param port
	 *            the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Getter
	 * 
	 * @return the termName
	 */
	public String getTermName() {
		return this.termName;
	}

	/**
	 * Setter
	 * 
	 * @param termName
	 *            the termName to set
	 */
	public void setTermName(String termName) {
		this.termName = termName;
	}

	/**
	 * Getter
	 * 
	 * @return the connectionStatus
	 */
	public EnumConnectionStatus getConnectionStatus() {
		return this.connectionStatus;
	}

	/**
	 * Getter
	 * 
	 * @return the socket
	 */
	public Socket getSocket() {
		return this.socket;
	}

}
