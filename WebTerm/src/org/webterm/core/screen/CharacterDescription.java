package org.webterm.core.screen;

/**
 * Character of the screen.
 * 
 * @author charles
 */
public final class CharacterDescription {
	
	/** Character */
	public char character = ' ';
	
	/** Font color */
	public Color colorFont = Color.WHITE;
	
	/** Background color */
	public Color colorBackground = Color.BLACK;
	
	/** True if character blinking */
	public boolean blink = false;
	
	/** True if character underlined */
	public boolean underlined = false;
	
	/**
	 * Constructor
	 */
	public CharacterDescription() {
		super();
	}
}
