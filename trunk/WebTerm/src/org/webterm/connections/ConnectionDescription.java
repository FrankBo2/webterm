package org.webterm.connections;

import java.io.IOException;
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
	 * @param serverName the serverName to set
	 */
	public void setServerName(final String serverName) {
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
	 * @param port the port to set
	 */
	public void setPort(final int port) {
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
	 * @param termName the termName to set
	 */
	public void setTermName(final String termName) {
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

	/**
	 * Open a connection with the host.
	 * 
	 * @return True if the connection is open succesfully with the host.
	 */
	public boolean openConnection() {
		synchronized (this.connectionStatus) {
			boolean result = false; // NOPMD - init result
			if (this.connectionStatus == EnumConnectionStatus.NOT_CREATED || this.connectionStatus == EnumConnectionStatus.CLOSED) {
				this.connectionStatus = EnumConnectionStatus.INITIALISATION;
				try {
					this.socket = new Socket(this.serverName, this.port);
					result = true;
					this.connectionStatus = EnumConnectionStatus.OPEN;
				} catch (IOException ex) {
					// FIXME
					this.connectionStatus = EnumConnectionStatus.NOT_CREATED;
				}
			}
			return result;
		}
	}

	/**
	 * Close the connection with the host.
	 * 
	 * @return True if the connection is closed succesfully.
	 */
	public boolean closeConnection() {
		synchronized (this.connectionStatus) {
			boolean result = false; // NOPMD - init result
			if (this.connectionStatus == EnumConnectionStatus.OPEN) {
				this.connectionStatus = EnumConnectionStatus.INITIALISATION;
				try {
					this.socket.close();
					result = true;
					this.connectionStatus = EnumConnectionStatus.CLOSED;
				} catch (IOException ex) {
					this.connectionStatus = EnumConnectionStatus.CLOSED;
				}
			}
			return result;
		}
	}
}
