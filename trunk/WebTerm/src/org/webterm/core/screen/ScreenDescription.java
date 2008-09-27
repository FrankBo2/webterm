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

import org.webterm.core.screen.field.ScreenFields;

/**
 * Screen description class.
 * 
 * @author charles
 */
public final class ScreenDescription {
	
	/** Height of the screen */
	public transient final int height;
	
	/** Width of the screen */
	public transient final int width;
	
	/** Screen details */
	private transient final CharacterDescription[][] screen;
	
	/** Fields in the screen */
	private transient final ScreenFields fields = new ScreenFields();
	
	/**
	 * Constructor
	 * 
	 * @param height Height of the screen
	 * @param width Width of the screen
	 */
	public ScreenDescription(final int height, final int width) {
		this.height = height;
		this.width = width;
		
		this.screen = new CharacterDescription[height][width];
		this.initScreen();
	}
	
	/**
	 * Initialization of the screen.
	 */
	public void initScreen() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				this.screen[i][j] = new CharacterDescription(); //NOPMD - initialize
			}
		}
	}
	/**
	 * Getter
	 * 
	 * @param x Horizontal position
	 * @param y Vertical position
	 * @return Character at position <code>x</code> : <code>y</code>
	 */
	public CharacterDescription get(final int x, final int y) { //NOPMD
		return this.screen[y][x];
	}
	
	/**
	 * Getter
	 * 
	 * @return Fields of the screen
	 */
	public ScreenFields getFields() {
		return this.fields;
	}
}
