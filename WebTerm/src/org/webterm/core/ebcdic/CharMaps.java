package org.webterm.core.ebcdic;

import java.util.HashMap;
import java.util.Map;

import org.webterm.core.ebcdic.maps.ICharMap;
import org.webterm.core.ebcdic.maps.Ibm0037;
import org.webterm.core.ebcdic.maps.Ibm0256;
import org.webterm.core.ebcdic.maps.Ibm0273;
import org.webterm.core.ebcdic.maps.Ibm0277;
import org.webterm.core.ebcdic.maps.Ibm0278;
import org.webterm.core.ebcdic.maps.Ibm0280;
import org.webterm.core.ebcdic.maps.Ibm0284;
import org.webterm.core.ebcdic.maps.Ibm0285;
import org.webterm.core.ebcdic.maps.Ibm0290;
import org.webterm.core.ebcdic.maps.Ibm0297;
import org.webterm.core.ebcdic.maps.Ibm0420;
import org.webterm.core.ebcdic.maps.Ibm0424;
import org.webterm.core.ebcdic.maps.Ibm0500;
import org.webterm.core.ebcdic.maps.Ibm0870;
import org.webterm.core.ebcdic.maps.Ibm0871;
import org.webterm.core.ebcdic.maps.Ibm0875;
import org.webterm.core.ebcdic.maps.Ibm0880;
import org.webterm.core.ebcdic.maps.Ibm0905;
import org.webterm.core.ebcdic.maps.Ibm1026;

/**
 * Code class to manage char map conversion for EBCDIC.
 * 
 * @author charles
 */
public final class CharMaps {

	/** Unique instance. */
	private static final CharMaps instance = new CharMaps();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static CharMaps getInstance() {
		return instance;
	}

	/** list of languages */
	private transient final Map<Integer, ICharMap> maps = new HashMap<Integer, ICharMap>();

	/** default char map */
	private transient ICharMap defaultCharMap;

	/**
	 * Constructor
	 */
	private CharMaps() {
		super();
		init();
	}

	/**
	 * Init list of languages
	 */
	private void init() {
		register(Ibm0037.getInstance());
		register(Ibm0256.getInstance());
		register(Ibm0273.getInstance());
		register(Ibm0277.getInstance());
		register(Ibm0278.getInstance());
		register(Ibm0280.getInstance());
		register(Ibm0284.getInstance());
		register(Ibm0285.getInstance());
		register(Ibm0290.getInstance());
		register(Ibm0297.getInstance());
		register(Ibm0420.getInstance());
		register(Ibm0424.getInstance());
		register(Ibm0500.getInstance());
		register(Ibm0870.getInstance());
		register(Ibm0871.getInstance());
		register(Ibm0875.getInstance());
		register(Ibm0880.getInstance());
		register(Ibm0905.getInstance());
		register(Ibm1026.getInstance());

		this.defaultCharMap = Ibm0297.getInstance();
	}

	/**
	 * Register method for char maps
	 * 
	 * @param charmap charmap to register
	 */
	private void register(final ICharMap charmap) {
		this.maps.put(Integer.valueOf(charmap.getServerIbmCode()), charmap);
	}

	/**
	 * Method to convert client String
	 * 
	 * @param map CharMap for conversion
	 * @param string String to convert
	 * @return String in the host char encoding
	 */
	public String stringEncode(final ICharMap map, final String string) {
		final StringBuilder str = new StringBuilder();
		final char[] encoder = map.getEncoder(); // NOPMD -init
		final int len = string.length();
		for (int i = 0; i < len; ++i) {
			str.append(encoder[string.charAt(i)]);
		}
		return str.toString();
	}

	/**
	 * Method to convert host String
	 * 
	 * @param map CharMap for conversion
	 * @param string String to convert
	 * @return String in the client char encoding
	 */
	public String stringDecode(final ICharMap map, final String string) {
		final StringBuilder str = new StringBuilder();
		final char[] decoder = map.getDecoder(); // NOPMD - init
		final int len = string.length();
		for (int i = 0; i < len; ++i) {
			str.append(decoder[string.charAt(i)]);
		}
		return str.toString();
	}

	/**
	 * Getter
	 * 
	 * @return default charMap
	 */
	public ICharMap getDefaultCharMap() {
		return this.defaultCharMap;
	}
}
