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

import org.webterm.term.ITermCreator;

/**
 * Creator for IBM 5250 terminals.
 * 
 * @author charles
 */
public final class Ibm5250TermCreator implements ITermCreator<Ibm5250TermDescription> {

	/** Unic instance of the class */
	private static final Ibm5250TermCreator instance = new Ibm5250TermCreator();

	/**
	 * Getter
	 * 
	 * @return Unic instance of the class
	 */
	public static Ibm5250TermCreator getInstance() {
		return instance;
	}

	/**
	 * Constructor.
	 */
	private Ibm5250TermCreator() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.ITermCreator#getTermType()
	 */
	@Override
	public String getTermType() {
		return ConstIbm5250.TERM_TYPE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.ITermCreator#newInstance()
	 */
	@Override
	public Ibm5250TermDescription newInstance() {
		return new Ibm5250TermDescription();
	}

}
