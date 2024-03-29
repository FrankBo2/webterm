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
 * Class for IBM 0880 code
 * 
 * @author charles
 */
public final class Ibm0880 implements ICharMap {

	/** Unique instance. */
	private static final Ibm0880 instance = new Ibm0880();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static Ibm0880 getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private Ibm0880() {
		super();
	}

	/** IBM server code */
	private static final int SERVER_CODE = 880;

	/** client code */
	private static final String CLIENT_CODE = "ISO8859-5"; //$NON-NLS-1$

	/** IBM 880 */
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
	100, 129, 130, 131, 132, 133, 134, 135, /* 96 - 103 */
	136, 137, 145, 146, 147, 148, 149, 150, /* 104 - 111 */
	151, 152, 153, 162, 163, 164, 165, 166, /* 112 - 119 */
	167, 168, 169, 161, 69, 115, 121, 7, /* 120 - 127 */
	32, 33, 34, 35, 36, 21, 6, 23, /* 128 - 135 */
	40, 41, 42, 43, 44, 9, 10, 27, /* 136 - 143 */
	48, 49, 26, 51, 52, 53, 54, 8, /* 144 - 151 */
	56, 57, 58, 59, 4, 20, 62, 255, /* 152 - 159 */
	192, 99, 89, 98, 208, 101, 102, 103, /* 160 - 167 */
	104, 105, 112, 113, 114, 65, 116, 117, /* 168 - 175 */
	185, 186, 237, 191, 188, 189, 236, 250, /* 176 - 183 */
	203, 204, 205, 206, 207, 218, 219, 220, /* 184 - 191 */
	222, 223, 234, 235, 190, 202, 187, 254, /* 192 - 199 */
	251, 253, 87, 239, 238, 252, 184, 221, /* 200 - 207 */
	119, 120, 175, 141, 138, 139, 174, 178, /* 208 - 215 */
	143, 144, 154, 155, 156, 157, 158, 159, /* 216 - 223 */
	170, 171, 172, 173, 140, 142, 128, 182, /* 224 - 231 */
	179, 181, 183, 177, 176, 180, 118, 160, /* 232 - 239 */
	88, 68, 66, 67, 106, 70, 71, 72, /* 240 - 247 */
	73, 81, 82, 83, 84, 225, 85, 86, /* 248 - 255 */
	};

	/** IBM 880 */
	private static final char[] DECODER = new char[] {

	0, 1, 2, 3, 156, 9, 134, 127, /* 0 - 7 */
	151, 141, 142, 11, 12, 13, 14, 15, /* 8 - 15 */
	16, 17, 18, 19, 157, 133, 8, 135, /* 16 - 23 */
	24, 25, 146, 143, 28, 29, 30, 31, /* 24 - 31 */
	128, 129, 130, 131, 132, 10, 23, 27, /* 32 - 39 */
	136, 137, 138, 139, 140, 5, 6, 7, /* 40 - 47 */
	144, 145, 22, 147, 148, 149, 150, 4, /* 48 - 55 */
	152, 153, 154, 155, 20, 21, 158, 26, /* 56 - 63 */
	32, 173, 242, 243, 241, 124, 245, 246, /* 64 - 71 */
	247, 248, 91, 46, 60, 40, 43, 33, /* 72 - 79 */
	38, 249, 250, 251, 252, 254, 255, 202, /* 80 - 87 */
	240, 162, 93, 36, 42, 41, 59, 94, /* 88 - 95 */
	45, 47, 163, 161, 96, 165, 166, 167, /* 96 - 103 */
	168, 169, 244, 44, 37, 95, 62, 63, /* 104 - 111 */
	170, 171, 172, 125, 174, 175, 238, 208, /* 112 - 119 */
	209, 126, 58, 35, 64, 39, 61, 34, /* 120 - 127 */
	230, 97, 98, 99, 100, 101, 102, 103, /* 128 - 135 */
	104, 105, 212, 213, 228, 211, 229, 216, /* 136 - 143 */
	217, 106, 107, 108, 109, 110, 111, 112, /* 144 - 151 */
	113, 114, 218, 219, 220, 221, 222, 223, /* 152 - 159 */
	239, 123, 115, 116, 117, 118, 119, 120, /* 160 - 167 */
	121, 122, 224, 225, 226, 227, 214, 210, /* 168 - 175 */
	236, 235, 215, 232, 237, 233, 231, 234, /* 176 - 183 */
	206, 176, 177, 198, 180, 181, 196, 179, /* 184 - 191 */
	160, 65, 66, 67, 68, 69, 70, 71, /* 192 - 199 */
	72, 73, 197, 184, 185, 186, 187, 188, /* 200 - 207 */
	164, 74, 75, 76, 77, 78, 79, 80, /* 208 - 215 */
	81, 82, 189, 190, 191, 207, 192, 193, /* 216 - 223 */
	92, 253, 83, 84, 85, 86, 87, 88, /* 224 - 231 */
	89, 90, 194, 195, 182, 178, 204, 203, /* 232 - 239 */
	48, 49, 50, 51, 52, 53, 54, 55, /* 240 - 247 */
	56, 57, 183, 200, 205, 201, 199, 159, /* 248 - 255 */
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
