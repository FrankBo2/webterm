package org.webterm.core.screen;

/**
 * Screen description class.
 * 
 * @author charles
 */
public final class ScreenDescription {
	
	/** Height of the screen */
	public transient final int height;
	
	/** Width of the screen */
	public transient final int width;
	
	/** Screen details */
	private transient final CharacterDescription[][] screen;
	
	/**
	 * Constructor
	 * 
	 * @param height Height of the screen
	 * @param width Width of the screen
	 */
	public ScreenDescription(final int height, final int width) {
		this.height = height;
		this.width = width;
		
		this.screen = new CharacterDescription[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				this.screen[i][j] = new CharacterDescription(); //NOPMD - initialize
			}
		}
	}
	
	/**
	 * Getter
	 * 
	 * @param x Horizontal position
	 * @param y Vertical position
	 * @return Character at position <code>x</code> : <code>y</code>
	 */
	public CharacterDescription get(final int x, final int y) { //NOPMD
		return this.screen[y][x];
	}
}
