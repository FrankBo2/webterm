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
package org.webterm.connections;

import java.io.IOException;
import java.net.Socket;

import org.webterm.term.AbstractTermDescription;

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
	
	/** terminal description of the connection*/
	transient private final AbstractTermDescription term;
	
	/** Connection handler */
	transient private ConnectionHandler connectionHandler = null;
 
	/**
	 * Constructor
	 * 
	 * @param term Terminal.
	 */
	public ConnectionDescription(final AbstractTermDescription term) {
		this.term = term;
	}
	
	/**
	 * Getter
	 * 
	 * @return Terminal description
	 */
	public AbstractTermDescription getTerm() {
		return this.term;
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
	 * @return True if the connection is open successfully with the host.
	 */
	public boolean openConnection() {
		synchronized (this.connectionStatus) {
			boolean result = false; // NOPMD - initialization result
			if (this.connectionStatus == EnumConnectionStatus.NOT_CREATED || this.connectionStatus == EnumConnectionStatus.CLOSED) {
				this.connectionStatus = EnumConnectionStatus.INITIALISATION;
				try {
					this.socket = new Socket(this.serverName, this.port);
					result = true;
					this.connectionStatus = EnumConnectionStatus.OPEN;
					this.connectionHandler = new ConnectionHandler(this.term, this.socket);
					this.connectionHandler.readScreen();
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
