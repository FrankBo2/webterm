package org.webterm.term;

import org.webterm.connections.ConnectionDescription;
import org.webterm.service.ConnectionPidHelper;

/**
 * Abstract class form Term description
 * 
 * @author charles
 */
public abstract class AbstractTermDescription { // NOPMD - no abstract methode

	/** PID of the the connection */
	private transient final Long pid;

	/** Owner of the term connection */
	private String owner;

	/** Name of the Terminal. */
	private transient final String termName;

	/** Desciption of ther term connection. */
	private transient final ConnectionDescription connDescription = new ConnectionDescription();

	/**
	 * Getter
	 * 
	 * @return Name of the Terminal.
	 */
	public final String getTermName() {
		return this.termName;
	}

	/**
	 * Getter
	 * 
	 * @return The Connection description.
	 */
	public final ConnectionDescription getConnectionDescription() {
		return this.connDescription;
	}

	/**
	 * Constructor
	 * 
	 * @param termName Name of the Terminal.
	 */
	protected AbstractTermDescription(final String termName) {
		this.termName = termName;
		this.pid = Long.valueOf(ConnectionPidHelper.getInstance().getNewConnectionPid());
	}

	/**
	 * Getter
	 * 
	 * @return Connection PID
	 */
	public Long getPid() {
		return this.pid;
	}

	/**
	 * Getter
	 * 
	 * @return the owner
	 */
	public String getOwner() {
		return this.owner;
	}

	/**
	 * Setter
	 * 
	 * @param owner the owner to set
	 */
	public void setOwner(final String owner) {
		this.owner = owner;
	}
}
