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
package org.webterm.core.screen;

import java.util.HashMap;
import java.util.Map;

/**
 * Character color details.
 * 
 * @author charles
 */
public enum CharacterColor {
	/** color */
    COLOR_0x20(Color.GREEN, false, false, Color.BLACK),
	/** color */
    COLOR_0x21(Color.BLACK, false, false, Color.GREEN),
	/** color */
    COLOR_0x22(Color.WHITE, false, false, Color.BLACK),
	/** color */
    COLOR_0x23(Color.BLACK, false, false, Color.WHITE),
	/** color */
    COLOR_0x24(Color.GREEN, false, true, Color.BLACK),
	/** color */
    COLOR_0x25(Color.BLACK, false, true, Color.GREEN),
	/** color */
    COLOR_0x26(Color.WHITE, false, true, Color.BLACK),
	/** color */
    COLOR_0x27(Color.BLACK, false, false, Color.BLACK),
	/** color */
    COLOR_0x28(Color.RED, false, false, Color.BLACK),
	/** color */
    COLOR_0x29(Color.BLACK, false, false, Color.RED),
	/** color */
    COLOR_0x2A(Color.RED, true, false, Color.BLACK),
	/** color */
    COLOR_0x2B(Color.BLACK, true, false, Color.RED),
	/** color */
    COLOR_0x2C(Color.RED, false, true, Color.BLACK),
	/** color */
    COLOR_0x2D(Color.BLACK, false, true, Color.RED),
	/** color */
    COLOR_0x2E(Color.RED, true, true, Color.BLACK),
	/** color */
    COLOR_0x2F(Color.BLACK, false, false, Color.BLACK),
	/** color */
    COLOR_0x30(Color.TURQUOISE, false, false, Color.BLACK),
	/** color */
    COLOR_0x31(Color.BLACK, false, false, Color.TURQUOISE),
	/** color */
    COLOR_0x32(Color.YELLOW, false, false, Color.BLACK),
	/** color */
    COLOR_0x33(Color.BLACK, false, false, Color.YELLOW),
	/** color */
    COLOR_0x34(Color.TURQUOISE, false, true, Color.BLACK),
	/** color */
    COLOR_0x35(Color.BLACK, false, true, Color.TURQUOISE),
	/** color */
    COLOR_0x36(Color.YELLOW, false, true, Color.BLACK),
	/** color */
    COLOR_0x37(Color.BLACK, false, false, Color.BLACK),
	/** color */
    COLOR_0x38(Color.PINK, false, false, Color.BLACK),
	/** color */
    COLOR_0x39(Color.BLACK, false, false, Color.PINK),
	/** color */
    COLOR_0x3A(Color.BLUE, false, false, Color.BLACK),
	/** color */
    COLOR_0x3B(Color.BLACK, false, false, Color.BLUE),
	/** color */
    COLOR_0x3C(Color.PINK, false, true, Color.BLACK),
	/** color */
    COLOR_0x3D(Color.BLACK, false, true, Color.PINK),
	/** color */
    COLOR_0x3E(Color.BLUE, false, true, Color.BLACK),
	/** color */
    COLOR_0x3F(Color.BLACK, false, false, Color.BLACK),
	/** color */
    COLOR_DEFAULT(Color.BLACK, false, false, Color.BLACK);

	/** Font color */
	public transient final Color colorFont;
	
	/** True if character blinking */
	public transient final boolean blink;
	
	/** True if character underlined */
	public transient final boolean underlined;
	
	/** Background color */
	public transient final Color colorBackground;
	
	/**
	 * Constructor
	 * 
	 * @param foreground Foreground color
	 * @param blink True if blinking
	 * @param underlined True if underlined
	 * @param background Background color
	 */
	private CharacterColor(final Color foreground, final boolean blink, final boolean underlined, final Color background) {
		this.colorFont = foreground;
		this.blink = blink;
		this.underlined = underlined;
		this.colorBackground = background;
	}
	
	/**
	 * Getter
	 * 
	 * @param colCode color code
	 * @return ColorDescription
	 */
	public static CharacterColor findColor(final char colCode) {
	    CharacterColor result = map.get(Integer.valueOf(colCode));
	    if (result == null) {
	    	result = COLOR_DEFAULT;
	    }
	    return result;
	}
	
	/** color map */
	private final static Map<Integer, CharacterColor> map = new HashMap<Integer, CharacterColor>();
	
	/** static initialization */
	static {
		map.put(Integer.valueOf(0x20), COLOR_0x20);
		map.put(Integer.valueOf(0x21), COLOR_0x21);
		map.put(Integer.valueOf(0x22), COLOR_0x22);
		map.put(Integer.valueOf(0x23), COLOR_0x23);
		map.put(Integer.valueOf(0x24), COLOR_0x24);
		map.put(Integer.valueOf(0x25), COLOR_0x25);
		map.put(Integer.valueOf(0x26), COLOR_0x26);
		map.put(Integer.valueOf(0x27), COLOR_0x27);
		map.put(Integer.valueOf(0x28), COLOR_0x28);
		map.put(Integer.valueOf(0x29), COLOR_0x29);
		map.put(Integer.valueOf(0x2A), COLOR_0x2A);
		map.put(Integer.valueOf(0x2B), COLOR_0x2B);
		map.put(Integer.valueOf(0x2C), COLOR_0x2C);
		map.put(Integer.valueOf(0x2D), COLOR_0x2D);
		map.put(Integer.valueOf(0x2E), COLOR_0x2E);
		map.put(Integer.valueOf(0x2F), COLOR_0x2F);
		map.put(Integer.valueOf(0x30), COLOR_0x30);
		map.put(Integer.valueOf(0x31), COLOR_0x31);
		map.put(Integer.valueOf(0x32), COLOR_0x32);
		map.put(Integer.valueOf(0x33), COLOR_0x33);
		map.put(Integer.valueOf(0x34), COLOR_0x34);
		map.put(Integer.valueOf(0x35), COLOR_0x35);
		map.put(Integer.valueOf(0x36), COLOR_0x36);
		map.put(Integer.valueOf(0x37), COLOR_0x37);
		map.put(Integer.valueOf(0x38), COLOR_0x38);
		map.put(Integer.valueOf(0x39), COLOR_0x39);
		map.put(Integer.valueOf(0x3A), COLOR_0x3A);
		map.put(Integer.valueOf(0x3B), COLOR_0x3B);
		map.put(Integer.valueOf(0x3C), COLOR_0x3C);
		map.put(Integer.valueOf(0x3D), COLOR_0x3D);
		map.put(Integer.valueOf(0x3E), COLOR_0x3E);
		map.put(Integer.valueOf(0x3F), COLOR_0x3F);
	}
}
