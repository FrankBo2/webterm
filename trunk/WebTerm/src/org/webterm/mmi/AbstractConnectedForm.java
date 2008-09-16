package org.webterm.mmi;

/**
 * Abstract class to managed connection request on the server.
 * 
 * @author charles
 */
public abstract class AbstractConnectedForm { // NOPMD - no abstract method

	/** Id of the Connection (SessionId) */
	private String connectionId;

	/**
	 * Getter
	 * 
	 * @return the connectionId
	 */
	public String getConnectionId() {
		return this.connectionId;
	}

	/**
	 * Setter
	 * 
	 * @param connectionId the connectionId to set
	 */
	public void setConnectionId(final String connectionId) {
		this.connectionId = connectionId;
	}

}
