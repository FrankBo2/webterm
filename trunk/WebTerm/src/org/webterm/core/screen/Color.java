package org.webterm.core.screen;

/**
 * Color of a character.
 * 
 * @author charles
 */
public enum Color {

	/** color */
	WHITE("#FFFFFF"), //$NON-NLS-1$
	
	/** color */
	BLACK("#000000"), //$NON-NLS-1$
	
	/** color */
	RED("#FF0000"), //$NON-NLS-1$
	
	/** color */
	GREEN("#00FF00"), //$NON-NLS-1$
	
	/** color */
	BLUE("#0000FF"), //$NON-NLS-1$
	
	/** color */
	TURQUOISE("#00FFFF"), //$NON-NLS-1$
	
	/** color */
	YELLOW("#FFFF00"), //$NON-NLS-1$
	
	/** color */
	PINK("#FF00FF"); //$NON-NLS-1$
	
	/** Code HTML for Color */
	public final String htmlCode;
	
	/**
	 * Constructor
	 * 
	 * @param htmlCode Code HTML for color.
	 */
	private Color(final String htmlCode) {
		this.htmlCode = htmlCode;
	}
}
