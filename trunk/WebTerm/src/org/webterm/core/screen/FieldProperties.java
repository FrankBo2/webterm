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


/**
 * @author charles
 *
 */
public class FieldProperties {

	/**
	 * Constructor
	 */
	public FieldProperties() {
		super();
	}
	
	/** FFW 0 */
	private char ffw0 = 0;
	/** FFW 1 */
	private char ffw1 = 0;
	/** FCW 0 */
	private char fcw0 = 0;
	/** FCW 1 */
	private char fcw1 = 0;
	
	/** Color */
	private CharacterColor color = CharacterColor.COLOR_DEFAULT;
	
	/** Length */
	private int length = 0;
	
	/** True if field Active */
	private boolean active = true;

	/**
	 * Getter
	 * 
	 * @return the ffw0
	 */
	public char getFfw0() {
		return this.ffw0;
	}

	/**
	 * Setter
	 * 
	 * @param ffw0 the ffw0 to set
	 */
	public void setFfw0(final char ffw0) {
		this.ffw0 = ffw0;
	}

	/**
	 * Getter
	 * 
	 * @return the ffw1
	 */
	public char getFfw1() {
		return this.ffw1;
	}

	/**
	 * Setter
	 * 
	 * @param ffw1 the ffw1 to set
	 */
	public void setFfw1(final char ffw1) {
		this.ffw1 = ffw1;
	}

	/**
	 * Getter
	 * 
	 * @return the fcw0
	 */
	public char getFcw0() {
		return this.fcw0;
	}

	/**
	 * Setter
	 * 
	 * @param fcw0 the fcw0 to set
	 */
	public void setFcw0(final char fcw0) {
		this.fcw0 = fcw0;
	}

	/**
	 * Getter
	 * 
	 * @return the fcw1
	 */
	public char getFcw1() {
		return this.fcw1;
	}

	/**
	 * Setter
	 * 
	 * @param fcw1 the fcw1 to set
	 */
	public void setFcw1(final char fcw1) {
		this.fcw1 = fcw1;
	}

	/**
	 * Getter
	 * 
	 * @return the color
	 */
	public CharacterColor getColor() {
		return this.color;
	}

	/**
	 * Setter
	 * 
	 * @param color the color to set
	 */
	public void setColor(final CharacterColor color) {
		this.color = color;
	}

	/**
	 * Getter
	 * 
	 * @return the length
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Setter
	 * 
	 * @param length the length to set
	 */
	public void setLength(final int length) {
		this.length = length;
	}

	/**
	 * Getter
	 * 
	 * @return the active
	 */
	public boolean isActive() {
		return this.active;
	}

	/**
	 * Setter
	 * 
	 * @param active the active to set
	 */
	public void setActive(final boolean active) {
		this.active = active;
	}
}
