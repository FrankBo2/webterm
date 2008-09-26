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
