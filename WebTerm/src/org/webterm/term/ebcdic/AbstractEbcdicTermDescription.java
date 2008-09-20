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

}
