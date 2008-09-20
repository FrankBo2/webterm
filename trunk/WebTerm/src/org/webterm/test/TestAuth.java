package org.webterm.test; // NOPMD - test class

import org.webterm.core.plugin.AutheticationPlugIn;
import org.webterm.core.plugin.authentication.AuthenticationProvider;

/**
 * Test class for authentication
 * 
 * @author charles
 */
public final class TestAuth {

	/**
	 * Main method
	 * 
	 * @param args arguments
	 */
	public static void main(final String[] args) {
		try {
			final AutheticationPlugIn plugin = new AutheticationPlugIn();
			plugin.init(null, null);
			System.out.println(AuthenticationProvider.getInstance().isValidUser("charles", "charles")); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
			System.out.println(AuthenticationProvider.getInstance().isValidUser("charles", "")); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
			System.out.println(AuthenticationProvider.getInstance().isValidUser("", "")); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
			plugin.destroy();
			System.exit(0); // NOPMD
		} catch (final Exception ex) {
			ex.printStackTrace(); // NOPMD
		}
	}

}
