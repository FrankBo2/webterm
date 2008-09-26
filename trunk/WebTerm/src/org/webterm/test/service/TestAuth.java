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
