package org.webterm.test.service; //NOPMD

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
		list.add(org.webterm.test.service.TestAuth.class); 
	}
}
