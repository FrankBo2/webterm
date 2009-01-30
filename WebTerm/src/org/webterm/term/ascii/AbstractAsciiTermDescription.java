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
package org.webterm.term.ascii;

import org.webterm.term.AbstractTermDescription;

/**
 * Abstract class for ASCII terminal description.
 * 
 * @author charles
 */
public abstract class AbstractAsciiTermDescription extends AbstractTermDescription {

	/**
	 * Constructor
	 * 
	 * @param termName Terminal name
	 */
	public AbstractAsciiTermDescription(final String termName) {
		super(termName);
	}
	
	/* 
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.term.AbstractTermDescription#encode(char)
	 */
	@Override
	public char encode(final char character) {
		return character;
	}
	
	/* 
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.term.AbstractTermDescription#decode(char)
	 */
	@Override
	public char decode(final char character) {
		return character;
	}
	
	/* 
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.term.AbstractTermDescription#encode(java.lang.String)
	 */
	@Override
	public String encode(final String str) {
		return str;
	}
	
	/* 
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.term.AbstractTermDescription#decode(java.lang.String)
	 */
	@Override
	public String decode(final String str) {
		return str;
	}

}
