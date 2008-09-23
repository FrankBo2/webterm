package org.webterm.test.core.ebcdic.maps;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.webterm.core.ebcdic.maps.Ibm0285;

/**
 * Tests for CharMap Ibm0285
 * 
 * @author charles
 */
public class TestIbm0285 {
	
	/**
	 * Test for authentication
	 */
	@Test
	public void testCharMap() {
		final char[] encoder = Ibm0285.getInstance().getEncoder(); //NOPMD - initialization
		final char[] decoder = Ibm0285.getInstance().getDecoder(); //NOPMD - initialization
		
		for (int i = 0; i < 256; i++) {
			final boolean test = decoder[encoder[i]] == i;
			assertTrue("check for Ibm0285 char map : " + Integer.toString(i), test); //$NON-NLS-1$
		}
	}

}
