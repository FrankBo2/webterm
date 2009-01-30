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
package org.webterm.test.core.ebcdic.maps; //NOPMD

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
	 * @param list List
	 */
	public static void completeTestClasses(final List<Class<?>> list) {
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0037.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0256.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0273.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0277.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0278.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0280.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0284.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0285.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0290.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0297.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0420.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0424.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0500.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0870.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0871.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0875.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0880.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm0905.class);
		list.add(org.webterm.test.core.ebcdic.maps.TestIbm1026.class);
	}
}
