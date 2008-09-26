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
package org.webterm.service.forms;

/**
 * Généric response for service request.
 * 
 * @author charles
 */
public abstract class AbstractServiceResult { // NOPMD - no abstract methode

	/**
	 * Enum for the result Status.
	 * 
	 * @author charles
	 */
	public enum Status {
		/** Ok */
		OK,
		/** error */
		ERROR;
	}

	/** Response status */
	private Status status = Status.ERROR;

	/** Response Message */
	private String message;

	/**
	 * Getter
	 * 
	 * @return the status
	 */
	public Status getStatus() {
		return this.status;
	}

	/**
	 * Setter
	 * 
	 * @param status the status to set
	 */
	public void setStatus(final Status status) {
		this.status = status;
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
}
