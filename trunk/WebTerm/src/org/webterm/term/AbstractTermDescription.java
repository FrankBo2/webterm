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
package org.webterm.term;

import org.webterm.connections.ConnectionDescription;
import org.webterm.service.ConnectionPidHelper;

/**
 * Abstract class form Term description
 * 
 * @author charles
 */
public abstract class AbstractTermDescription { // NOPMD - no abstract method

	/** PID of the the connection */
	private transient final Long pid;

	/** Owner of the term connection */
	private String owner;

	/** Name of the Terminal. */
	private transient final String termName;

	/** Description of the term connection. */
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
