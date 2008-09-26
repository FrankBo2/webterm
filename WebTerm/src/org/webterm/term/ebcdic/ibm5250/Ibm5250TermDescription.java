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

import org.webterm.term.ebcdic.AbstractEbcdicTermDescription;

/**
 * Term description for IBM 5250 ASCII terminal.
 * 
 * @author charles
 */
public final class Ibm5250TermDescription extends AbstractEbcdicTermDescription {

	/**
	 * Constructor.
	 */
	public Ibm5250TermDescription() {
		super(ConstIbm5250.TERM_TYPE);
	}

	/* 
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.term.AbstractTermDescription#getHeight()
	 */
	@Override
	public int getHeight() {
		return 24;
	}

	/* 
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.term.AbstractTermDescription#getWidth()
	 */
	@Override
	public int getWidth() {
		return 80;
	}

}
