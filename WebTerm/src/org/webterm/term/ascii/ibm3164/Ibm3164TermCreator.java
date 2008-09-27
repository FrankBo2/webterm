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

import org.webterm.term.ITermCreator;

/**
 * Creator for IBM 3164 terminals.
 * 
 * @author charles
 */
public final class Ibm3164TermCreator implements ITermCreator<Ibm3164TermDescription> {

	/** Unique instance of the class */
	private static final Ibm3164TermCreator instance = new Ibm3164TermCreator();

	/**
	 * Getter
	 * 
	 * @return Unique instance of the class
	 */
	public static Ibm3164TermCreator getInstance() {
		return instance;
	}

	/**
	 * Constructor.
	 */
	private Ibm3164TermCreator() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.ITermCreator#getTermType()
	 */
	@Override
	public String getTermType() {
		return ConstIbm3164.TERM_TYPE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.ITermCreator#newInstance()
	 */
	@Override
	public Ibm3164TermDescription newInstance() {
		return new Ibm3164TermDescription();
	}

}
