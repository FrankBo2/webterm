package org.webterm.test.core.ebcdic.maps;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.webterm.core.ebcdic.maps.Ibm0290;

/**
 * Tests for CharMap Ibm0290
 * 
 * @author charles
 */
public class TestIbm0290 {
	
	/**
	 * Test for authentication
	 */
	@Test
	public void testCharMap() {
		final char[] encoder = Ibm0290.getInstance().getEncoder(); //NOPMD - initialization
		final char[] decoder = Ibm0290.getInstance().getDecoder(); //NOPMD - initialization
		
		for (int i = 0; i < 256; i++) {
			final boolean test = decoder[encoder[i]] == i;
			assertTrue("check for Ibm0290 char map : " + Integer.toString(i), test); //$NON-NLS-1$
		}
	}

}
