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
package org.webterm.term.ascii.ibm3164;

import org.webterm.term.ascii.AbstractAsciiTermDescription;

/**
 * Term description for IBM 3164 ASCII terminal.
 * 
 * @author charles
 */
public final class Ibm3164TermDescription extends AbstractAsciiTermDescription {

	/**
	 * Constructor.
	 */
	public Ibm3164TermDescription() {
		super(ConstIbm3164.TERM_TYPE);
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

	/* 
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.term.AbstractTermDescription#getPhysicalTermType()
	 */
	@Override
	public String getPhysicalTermType() {
		return ConstIbm3164.PHY_TERM_TYPE;
	}
		
}
