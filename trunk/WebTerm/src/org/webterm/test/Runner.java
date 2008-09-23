package org.webterm.test; //NOPMD - test runner depend on lot of test classes

import java.io.PrintStream;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

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
		final Result result = JUnitCore.runClasses(new Class[] {
			org.webterm.test.service.TestAuth.class, 
			org.webterm.test.core.ebcdic.maps.TestIbm0037.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0256.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0273.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0277.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0278.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0280.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0284.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0285.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0290.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0297.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0420.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0424.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0500.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0870.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0871.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0875.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0880.class,
			org.webterm.test.core.ebcdic.maps.TestIbm0905.class,
			org.webterm.test.core.ebcdic.maps.TestIbm1026.class 
		});
		
		final PrintStream out = System.out;
		out.println(""); //$NON-NLS-1$
		out.print("Results for "); //$NON-NLS-1$
		out.print(result.getRunCount());
		out.print(" tests ["); //$NON-NLS-1$
		out.print(result.getRunTime());
		out.println("ms]"); //$NON-NLS-1$
		out.print('\t');
		out.print(result.getIgnoreCount());
		out.print(" ignored\t"); //$NON-NLS-1$
		out.print(result.getFailureCount());
		out.println(" failed"); //$NON-NLS-1$
	}
}
