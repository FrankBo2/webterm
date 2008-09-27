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
package org.webterm.test.core.ebcdic.maps;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.webterm.core.ebcdic.maps.Ibm0880;

/**
 * Tests for CharMap Ibm0880
 * 
 * @author charles
 */
public class TestIbm0880 {
	
	/**
	 * Test for authentication
	 */
	@Test
	public void testCharMap() {
		final char[] encoder = Ibm0880.getInstance().getEncoder(); //NOPMD - initialization
		final char[] decoder = Ibm0880.getInstance().getDecoder(); //NOPMD - initialization
		
		for (int i = 0; i < 256; i++) {
			final boolean test = decoder[encoder[i]] == i;
			assertTrue("check for Ibm0880 char map : " + Integer.toString(i), test); //$NON-NLS-1$
		}
	}

}