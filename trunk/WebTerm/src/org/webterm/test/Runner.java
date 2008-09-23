package org.webterm.test; //NOPMD - test runner depend on lot of test classes

import java.io.PrintStream;
import java.util.ArrayList;

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
		final ArrayList<Class<?>> list = new ArrayList<Class<?>>();
		Tester.completeTestClasses(list);
		final Result result = JUnitCore.runClasses(list.toArray(new Class[list.size()]));
		
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
