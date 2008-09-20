package org.webterm.test;

import org.junit.runner.JUnitCore;

/**
 * Application tester
 * 
 * @author charles
 */
public final class Runner {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		final Runner run = new Runner();
		run.executeTest();
		//System.exit(0); //NOPMD
	}

	/**
	 * Test Method.
	 */
	public void executeTest() {
		JUnitCore.main("org.webterm.test.TestAuth"); //$NON-NLS-1$
	}
}
