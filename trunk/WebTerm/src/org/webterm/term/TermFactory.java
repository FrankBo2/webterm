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
package org.webterm.term;

import java.util.HashMap;
import java.util.Map;

import org.webterm.term.ascii.ibm3164.Ibm3164TermCreator;
import org.webterm.term.ebcdic.ibm5250.Ibm5250TermCreator;

/**
 * Factory for terminals.
 * 
 * @author charles
 */
public final class TermFactory {

	/** Map for registered creators */
	private transient final Map<String, ITermCreator<? extends AbstractTermDescription>> creators = new HashMap<String, ITermCreator<? extends AbstractTermDescription>>();

	/** Unique instance of the class */
	private static final TermFactory instance = new TermFactory();

	/**
	 * Getter
	 * 
	 * @return Unique instance of the class
	 */
	public static TermFactory getInstance() {
		return instance;
	}

	/**
	 * Register methode for creators.
	 * 
	 * @param creator
	 */
	private void register(final ITermCreator<? extends AbstractTermDescription> creator) {
		this.creators.put(creator.getTermType(), creator);
	}

	/**
	 * Constructor
	 */
	private TermFactory() {
		super();
		register(Ibm3164TermCreator.getInstance());
		register(Ibm5250TermCreator.getInstance());
	}

	/**
	 * Creation methode for term description.
	 * 
	 * @param type Terminal type.
	 * @return A brand new instance of the terminal description if <i>type</i> is found in <i>creators</i>, null otherwidth.
	 */
	public AbstractTermDescription create(final String type) {
		final ITermCreator<? extends AbstractTermDescription> creator = this.creators.get(type);
		return creator == null ? null : creator.newInstance();
	}
}
