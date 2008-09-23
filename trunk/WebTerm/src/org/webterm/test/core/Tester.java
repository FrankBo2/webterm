package org.webterm.test.core; //NOPMD

import java.util.List;

/**
 * Class for test
 * 
 * @author charles
 */
public final class Tester {
	
	/**
	 * Method for test list.
	 * 
	 * @param list
	 */
	public static void completeTestClasses(final List<Class<?>> list) {
		org.webterm.test.core.ebcdic.Tester.completeTestClasses(list);
	}
}
