package org.webterm.test; // NOPMD - test class

import junit.framework.TestCase;

import org.junit.Test;
import org.webterm.core.plugin.AutheticationPlugIn;
import org.webterm.core.plugin.authentication.AuthenticationProvider;

/**
 * Test class for authentication
 * 
 * @author charles
 */
public final class TestAuth extends TestCase {

	/**
	 * Test for authentication
	 */
	@Test 
	public void testAuth() {
		try {
			final AutheticationPlugIn plugin = new AutheticationPlugIn();
			plugin.init(null, null);
			{
				final boolean test = AuthenticationProvider.getInstance().isValidUser("charles", "charles"); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
				assertTrue("login + password", test); //$NON-NLS-1$
			}
			{
				final boolean test = AuthenticationProvider.getInstance().isValidUser("charles", ""); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
				assertTrue("login without password", test); //$NON-NLS-1$
			}
			{
				final boolean test = AuthenticationProvider.getInstance().isValidUser("", ""); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
				assertTrue("empty check", test); //$NON-NLS-1$
			}
			plugin.destroy();
		} catch (final Exception ex) {
			ex.printStackTrace(); // NOPMD
		}
	}

}
