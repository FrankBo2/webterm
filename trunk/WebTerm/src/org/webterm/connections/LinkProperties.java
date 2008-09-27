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

/**
 * @author charles
 *
 */
public class LinkProperties {

	/** link property */
	private boolean endOfRecord = false;

	/** link property */
	private boolean binary = false;

	/**
	 * Getter
	 * 
	 * @return the endOfRecord
	 */
	public boolean isEndOfRecord() {
		return this.endOfRecord;
	}

	/**
	 * Setter
	 * 
	 * @param endOfRecord the endOfRecord to set
	 */
	public void setEndOfRecord(final boolean endOfRecord) {
		this.endOfRecord = endOfRecord;
	}

	/**
	 * Getter
	 * 
	 * @return the binary
	 */
	public boolean isBinary() {
		return this.binary;
	}

	/**
	 * Setter
	 * 
	 * @param binary the binary to set
	 */
	public void setBinary(final boolean binary) {
		this.binary = binary;
	}
	
}
