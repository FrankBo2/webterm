package org.webterm.test; // NOPMD - test class

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.webterm.core.plugin.AutheticationPlugIn;
import org.webterm.core.plugin.authentication.AuthenticationProvider;

/**
 * Test class for authentication
 * 
 * @author charles
 */
public final class TestAuth {

	/** authentication plug-in */
	private transient final AutheticationPlugIn plugin = new AutheticationPlugIn();

	/**
	 * Init method
	 */
	@Before
	public void init() {
		this.plugin.init(null, null);
	}

	/**
	 * Test for authentication
	 */
	@Test
	public void test1() {
		final boolean test = AuthenticationProvider.getInstance().isValidUser("charles", "charles"); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
		assertTrue("login + password", test); //$NON-NLS-1$
	}

	/**
	 * Test for authentication
	 */
	@Test
	public void test2() {
		final boolean test = AuthenticationProvider.getInstance().isValidUser("charles", ""); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
		assertFalse("login without password", test); //$NON-NLS-1$
	}

	/**
	 * Test for authentication
	 */
	@Test
	public void test3() {
		final boolean test = AuthenticationProvider.getInstance().isValidUser("", ""); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
		assertFalse("empty check", test); //$NON-NLS-1$
	}

	/**
	 * Destroy method.
	 */
	@After
	public void destroy() {
		this.plugin.destroy();
	}

}
