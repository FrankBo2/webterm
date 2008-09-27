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
package org.webterm.core.screen.field;

import java.util.ArrayList;
import java.util.List;

/**
 * @author charles
 *
 */
public class ScreenFields {

	/** list of fields */
	transient private final List<FieldProperties> fields = new ArrayList<FieldProperties>();
	
	/** Id of active field*/
	private int active = 0;
	
	/**
	 * Constructor
	 */
	public ScreenFields() {
		super();
	}
	
	/**
	 * Initialization method in order to clean the list of fileds.
	 */
	public void init() {
		this.fields.clear();
		this.active = 0;
	}

	/**
	 * Getter
	 * 
	 * @return the active
	 */
	public int getActive() {
		return this.active;
	}

	/**
	 * Setter
	 * 
	 * @param active the active to set
	 */
	public void setActive(final int active) {
		this.active = active;
	}

	/**
	 * Getter
	 * 
	 * @return the fields
	 */
	public List<FieldProperties> getFields() {
		return this.fields;
	}
}
