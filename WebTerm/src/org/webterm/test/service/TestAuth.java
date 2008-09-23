package org.webterm.test.service; // NOPMD - test class

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.webterm.core.plugin.authentication.AuthenticationPlugin;
import org.webterm.service.AuthenticationService;

/**
 * Test class for authentication
 * 
 * @author charles
 */
public final class TestAuth {

	/**
	 * Initialization method
	 */
	@Before
	public void init() {
		AuthenticationPlugin.getInstance().init();
	}

	/**
	 * Destroy method
	 */
	@After
	public void destroy() {
		AuthenticationPlugin.getInstance().destroy();
	}

	/**
	 * Test for authentication
	 */
	@Test
	public void test1() {
		final boolean test = AuthenticationService.getInstance().isValidUser("charles", "charles"); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
		assertTrue("login + password", test); //$NON-NLS-1$
	}

	/**
	 * Test for authentication
	 */
	@Test
	public void test2() {
		final boolean test = AuthenticationService.getInstance().isValidUser("charles", ""); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
		assertFalse("login without password", test); //$NON-NLS-1$
	}

	/**
	 * Test for authentication
	 */
	@Test
	public void test3() {
		final boolean test = AuthenticationService.getInstance().isValidUser("", ""); //$NON-NLS-1$ //$NON-NLS-2$ //NOPMD
		assertFalse("empty check", test); //$NON-NLS-1$
	}

}
