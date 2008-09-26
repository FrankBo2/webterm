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
package org.webterm.service;

/**
 * Helper for PID management.
 * 
 * @author charles
 */
public final class ConnectionPidHelper {

	/** unique instance*/
	private static final ConnectionPidHelper instance = new ConnectionPidHelper();
	
	/**
	 * Getter
	 * 
	 * @return Unique instance
	 */
	public static ConnectionPidHelper getInstance() {
		return instance;
	}
	
	/** cur PID value */
	private transient long pid = 0;
	
	/**
	 * Constructor
	 */
	private ConnectionPidHelper() {
		super();
	}
	
	/**
	 * Getter
	 * 
	 * @return New PID value
	 */
	public long getNewConnectionPid() {
		synchronized (instance) {
			return this.pid++;
		}
	}
}
