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
package org.webterm.term.ebcdic.ibm5250;

/**
 * Const class for IBM 5250 terminals.
 * 
 * @author charles
 */
public final class ConstIbm5250 {

	/**
	 * Constructor
	 */
	private ConstIbm5250() {
		super();
	}

	/** Type of Terminal */
	public static final String TERM_TYPE = "IBM-5250"; //$NON-NLS-1$
	
	/** Physical type of terminal */
	public static final String PHY_TERM_TYPE = "IBM-3179-2"; //$NON-NLS-1$
}
