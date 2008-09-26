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
 * Color of a character.
 * 
 * @author charles
 */
public enum Color {

	/** color */
	WHITE("#FFFFFF"), //$NON-NLS-1$
	
	/** color */
	BLACK("#000000"), //$NON-NLS-1$
	
	/** color */
	RED("#FF0000"), //$NON-NLS-1$
	
	/** color */
	GREEN("#00FF00"), //$NON-NLS-1$
	
	/** color */
	BLUE("#0000FF"), //$NON-NLS-1$
	
	/** color */
	TURQUOISE("#00FFFF"), //$NON-NLS-1$
	
	/** color */
	YELLOW("#FFFF00"), //$NON-NLS-1$
	
	/** color */
	PINK("#FF00FF"); //$NON-NLS-1$
	
	/** Code HTML for Color */
	public final String htmlCode;
	
	/**
	 * Constructor
	 * 
	 * @param htmlCode Code HTML for color.
	 */
	private Color(final String htmlCode) {
		this.htmlCode = htmlCode;
	}

}
