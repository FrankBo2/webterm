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
package org.webterm.core.ebcdic.maps;

/**
 * Class for IBM 0870 code
 * 
 * @author charles
 */
public final class Ibm0870 implements ICharMap {

	/** Unique instance. */
	private static final Ibm0870 instance = new Ibm0870();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static Ibm0870 getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private Ibm0870() {
		super();
	}

	/** IBM server code */
	private static final int SERVER_CODE = 870;

	/** client code */
	private static final String CLIENT_CODE = "ISO8859-2"; //$NON-NLS-1$

	/** IBM 870 */
	private static final char[] ENCODER = new char[] {

	0, 1, 2, 3, 55, 45, 46, 47, /* 0 - 7 */
	22, 5, 37, 11, 12, 13, 14, 15, /* 8 - 15 */
	16, 17, 18, 19, 60, 61, 50, 38, /* 16 - 23 */
	24, 25, 63, 39, 28, 29, 30, 31, /* 24 - 31 */
	64, 79, 127, 123, 91, 108, 80, 125, /* 32 - 39 */
	77, 93, 92, 78, 107, 96, 75, 97, /* 40 - 47 */
	240, 241, 242, 243, 244, 245, 246, 247, /* 48 - 55 */
	248, 249, 122, 94, 76, 126, 110, 111, /* 56 - 63 */
	124, 193, 194, 195, 196, 197, 198, 199, /* 64 - 71 */
	200, 201, 209, 210, 211, 212, 213, 214, /* 72 - 79 */
	215, 216, 217, 226, 227, 228, 229, 230, /* 80 - 87 */
	231, 232, 233, 74, 224, 90, 95, 109, /* 88 - 95 */
	121, 129, 130, 131, 132, 133, 134, 135, /* 96 - 103 */
	136, 137, 145, 146, 147, 148, 149, 150, /* 104 - 111 */
	151, 152, 153, 162, 163, 164, 165, 166, /* 112 - 119 */
	167, 168, 169, 192, 106, 208, 161, 7, /* 120 - 127 */
	32, 33, 34, 35, 36, 21, 6, 23, /* 128 - 135 */
	40, 41, 42, 43, 44, 9, 10, 27, /* 136 - 143 */
	48, 49, 26, 51, 52, 53, 54, 8, /* 144 - 151 */
	56, 57, 58, 59, 4, 20, 62, 255, /* 152 - 159 */
	65, 177, 128, 82, 159, 119, 170, 181, /* 160 - 167 */
	189, 188, 118, 253, 186, 202, 185, 180, /* 168 - 175 */
	144, 160, 158, 154, 190, 87, 138, 112, /* 176 - 183 */
	157, 156, 143, 221, 184, 100, 183, 178, /* 184 - 191 */
	237, 101, 66, 68, 99, 120, 105, 104, /* 192 - 199 */
	103, 113, 102, 115, 218, 117, 114, 250, /* 200 - 207 */
	172, 187, 171, 238, 235, 239, 236, 191, /* 208 - 215 */
	174, 116, 254, 251, 252, 173, 86, 89, /* 216 - 223 */
	205, 69, 98, 70, 67, 88, 73, 72, /* 224 - 231 */
	71, 81, 175, 83, 223, 85, 179, 234, /* 232 - 239 */
	140, 155, 139, 206, 203, 207, 204, 225, /* 240 - 247 */
	142, 84, 222, 219, 220, 141, 176, 182, /* 248 - 255 */
	};

	/** IBM 870 */
	private static final char[] DECODER = new char[] {

	0, 1, 2, 3, 156, 9, 134, 127, /* 0 - 7 */
	151, 141, 142, 11, 12, 13, 14, 15, /* 8 - 15 */
	16, 17, 18, 19, 157, 133, 8, 135, /* 16 - 23 */
	24, 25, 146, 143, 28, 29, 30, 31, /* 24 - 31 */
	128, 129, 130, 131, 132, 10, 23, 27, /* 32 - 39 */
	136, 137, 138, 139, 140, 5, 6, 7, /* 40 - 47 */
	144, 145, 22, 147, 148, 149, 150, 4, /* 48 - 55 */
	152, 153, 154, 155, 20, 21, 158, 26, /* 56 - 63 */
	32, 160, 194, 228, 195, 225, 227, 232, /* 64 - 71 */
	231, 230, 91, 46, 60, 40, 43, 33, /* 72 - 79 */
	38, 233, 163, 235, 249, 237, 222, 181, /* 80 - 87 */
	229, 223, 93, 36, 42, 41, 59, 94, /* 88 - 95 */
	45, 47, 226, 196, 189, 193, 202, 200, /* 96 - 103 */
	199, 198, 124, 44, 37, 95, 62, 63, /* 104 - 111 */
	183, 201, 206, 203, 217, 205, 170, 165, /* 112 - 119 */
	197, 96, 58, 35, 64, 39, 61, 34, /* 120 - 127 */
	162, 97, 98, 99, 100, 101, 102, 103, /* 128 - 135 */
	104, 105, 182, 242, 240, 253, 248, 186, /* 136 - 143 */
	176, 106, 107, 108, 109, 110, 111, 112, /* 144 - 151 */
	113, 114, 179, 241, 185, 184, 178, 164, /* 152 - 159 */
	177, 126, 115, 116, 117, 118, 119, 120, /* 160 - 167 */
	121, 122, 166, 210, 208, 221, 216, 234, /* 168 - 175 */
	254, 161, 191, 238, 175, 167, 255, 190, /* 176 - 183 */
	188, 174, 172, 209, 169, 168, 180, 215, /* 184 - 191 */
	123, 65, 66, 67, 68, 69, 70, 71, /* 192 - 199 */
	72, 73, 173, 244, 246, 224, 243, 245, /* 200 - 207 */
	125, 74, 75, 76, 77, 78, 79, 80, /* 208 - 215 */
	81, 82, 204, 251, 252, 187, 250, 236, /* 216 - 223 */
	92, 247, 83, 84, 85, 86, 87, 88, /* 224 - 231 */
	89, 90, 239, 212, 214, 192, 211, 213, /* 232 - 239 */
	48, 49, 50, 51, 52, 53, 54, 55, /* 240 - 247 */
	56, 57, 207, 219, 220, 171, 218, 159, /* 248 - 255 */
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.ebcdic.maps.ICharMap#getClientCharCode()
	 */
	@Override
	public String getClientCharCode() {
		return CLIENT_CODE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.ebcdic.maps.ICharMap#getDecoder()
	 */
	@Override
	public char[] getDecoder() {
		return DECODER; // NOPMD
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.ebcdic.maps.ICharMap#getEncoder()
	 */
	@Override
	public char[] getEncoder() {
		return ENCODER; // NOPMD
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.ebcdic.maps.ICharMap#getServerIbmCode()
	 */
	@Override
	public int getServerIbmCode() {
		return SERVER_CODE;
	}

}
