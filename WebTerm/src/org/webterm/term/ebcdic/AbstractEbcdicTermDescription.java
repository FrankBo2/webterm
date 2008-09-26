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
package org.webterm.term.ebcdic;

import org.webterm.core.ebcdic.CharMaps;
import org.webterm.core.ebcdic.maps.ICharMap;
import org.webterm.term.AbstractTermDescription;

/**
 * AbstractClass for EBCDI term description.
 * 
 * @author charles
 */
public abstract class AbstractEbcdicTermDescription extends AbstractTermDescription {

	/** Char map for EBCDIC */
	private ICharMap charMap = CharMaps.getInstance().getDefaultCharMap();

	/**
	 * @param termName
	 */
	public AbstractEbcdicTermDescription(final String termName) {
		super(termName);
	}

	/**
	 * Getter
	 * 
	 * @return the charMap
	 */
	public ICharMap getCharMap() {
		return this.charMap;
	}

	/**
	 * Setter
	 * 
	 * @param charMap the charMap to set
	 */
	public void setCharMap(final ICharMap charMap) {
		this.charMap = charMap;
	}
	
	/** CharMaps for EBCDIC */
	private static final CharMaps charMaps = CharMaps.getInstance();
	
	/** map encoding */
	private transient final ICharMap map = charMaps.getDefaultCharMap();
	
	/* 
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.term.AbstractTermDescription#encode(char)
	 */
	@Override
	public char encode(final char character) {
		return charMaps.stringEncode(this.map, character);
	}
	
	/* 
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.term.AbstractTermDescription#decode(char)
	 */
	@Override
	public char decode(final char character) {
		return charMaps.stringDecode(this.map, character);
	}

}
