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
package org.webterm.test; //NOPMD

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
		org.webterm.test.core.Tester.completeTestClasses(list);
		org.webterm.test.service.Tester.completeTestClasses(list);
	}
}
