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
package org.webterm.core.screen;

import org.webterm.core.ConstString;

/**
 * Class for queue
 * 
 * @author charles
 */
public class QueueProperties {
	
	/** message */
    private String message = ConstString.EMPTY;
	
	/** log */
    private String log = ConstString.EMPTY;
	
	/** type */
    private String type = ConstString.EMPTY;
	
	/** statut */
    private String status = ConstString.EMPTY;
	
	/**
	 * Constructor
	 */
	public QueueProperties() {
		super();
	}

	/**
	 * Getter
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Setter
	 * 
	 * @param message the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * Getter
	 * 
	 * @return the log
	 */
	public String getLog() {
		return this.log;
	}

	/**
	 * Setter
	 * 
	 * @param log the log to set
	 */
	public void setLog(final String log) {
		this.log = log;
	}

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
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Setter
	 * 
	 * @param status the status to set
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

}
