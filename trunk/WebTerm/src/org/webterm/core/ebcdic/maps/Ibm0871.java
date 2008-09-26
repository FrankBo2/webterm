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
 * Class for IBM 0871 code
 * 
 * @author charles
 */
public final class Ibm0871 implements ICharMap {

	/** Unique instance. */
	private static final Ibm0871 instance = new Ibm0871();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static Ibm0871 getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private Ibm0871() {
		super();
	}

	/** IBM server code */
	private static final int SERVER_CODE = 871;

	/** client code */
	private static final String CLIENT_CODE = "ISO8859-1"; //$NON-NLS-1$

	/** IBM 871 */
	private static final char[] ENCODER = new char[] {

	0, 1, 2, 3, 55, 45, 46, 47, /* 0 - 7 */
	22, 5, 37, 11, 12, 13, 14, 15, /* 8 - 15 */
	16, 17, 18, 19, 60, 61, 50, 38, /* 16 - 23 */
	24, 25, 63, 39, 28, 29, 30, 31, /* 24 - 31 */
	64, 79, 127, 123, 91, 108, 80, 125, /* 32 - 39 */
	77, 93, 92, 78, 107, 96, 75, 97, /* 40 - 47 */
	240, 241, 242, 243, 244, 245, 246, 247, /* 48 - 55 */
	248, 249, 122, 94, 76, 126, 110, 111, /* 56 - 63 */
	172, 193, 194, 195, 196, 197, 198, 199, /* 64 - 71 */
	200, 201, 209, 210, 211, 212, 213, 214, /* 72 - 79 */
	215, 216, 217, 226, 227, 228, 229, 230, /* 80 - 87 */
	231, 232, 233, 174, 190, 158, 236, 109, /* 88 - 95 */
	140, 129, 130, 131, 132, 133, 134, 135, /* 96 - 103 */
	136, 137, 145, 146, 147, 148, 149, 150, /* 104 - 111 */
	151, 152, 153, 162, 163, 164, 165, 166, /* 112 - 119 */
	167, 168, 169, 142, 187, 156, 204, 7, /* 120 - 127 */
	32, 33, 34, 35, 36, 21, 6, 23, /* 128 - 135 */
	40, 41, 42, 43, 44, 9, 10, 27, /* 136 - 143 */
	48, 49, 26, 51, 52, 53, 54, 8, /* 144 - 151 */
	56, 57, 58, 59, 4, 20, 62, 255, /* 152 - 159 */
	65, 170, 176, 177, 159, 178, 106, 181, /* 160 - 167 */
	189, 180, 154, 138, 186, 202, 175, 188, /* 168 - 175 */
	144, 143, 234, 250, 224, 160, 182, 179, /* 176 - 183 */
	157, 218, 155, 139, 183, 184, 185, 171, /* 184 - 191 */
	100, 101, 98, 102, 99, 103, 90, 104, /* 192 - 199 */
	116, 113, 114, 115, 120, 117, 118, 119, /* 200 - 207 */
	124, 105, 237, 238, 235, 239, 95, 191, /* 208 - 215 */
	128, 253, 254, 251, 252, 173, 192, 89, /* 216 - 223 */
	68, 69, 66, 70, 67, 71, 208, 72, /* 224 - 231 */
	84, 81, 82, 83, 88, 85, 86, 87, /* 232 - 239 */
	121, 73, 205, 206, 203, 207, 161, 225, /* 240 - 247 */
	112, 221, 222, 219, 220, 141, 74, 223, /* 248 - 255 */
	};

	/** IBM 871 */
	private static final char[] DECODER = new char[] {

	0, 1, 2, 3, 156, 9, 134, 127, /* 0 - 7 */
	151, 141, 142, 11, 12, 13, 14, 15, /* 8 - 15 */
	16, 17, 18, 19, 157, 133, 8, 135, /* 16 - 23 */
	24, 25, 146, 143, 28, 29, 30, 31, /* 24 - 31 */
	128, 129, 130, 131, 132, 10, 23, 27, /* 32 - 39 */
	136, 137, 138, 139, 140, 5, 6, 7, /* 40 - 47 */
	144, 145, 22, 147, 148, 149, 150, 4, /* 48 - 55 */
	152, 153, 154, 155, 20, 21, 158, 26, /* 56 - 63 */
	32, 160, 226, 228, 224, 225, 227, 229, /* 64 - 71 */
	231, 241, 254, 46, 60, 40, 43, 33, /* 72 - 79 */
	38, 233, 234, 235, 232, 237, 238, 239, /* 80 - 87 */
	236, 223, 198, 36, 42, 41, 59, 214, /* 88 - 95 */
	45, 47, 194, 196, 192, 193, 195, 197, /* 96 - 103 */
	199, 209, 166, 44, 37, 95, 62, 63, /* 104 - 111 */
	248, 201, 202, 203, 200, 205, 206, 207, /* 112 - 119 */
	204, 240, 58, 35, 208, 39, 61, 34, /* 120 - 127 */
	216, 97, 98, 99, 100, 101, 102, 103, /* 128 - 135 */
	104, 105, 171, 187, 96, 253, 123, 177, /* 136 - 143 */
	176, 106, 107, 108, 109, 110, 111, 112, /* 144 - 151 */
	113, 114, 170, 186, 125, 184, 93, 164, /* 152 - 159 */
	181, 246, 115, 116, 117, 118, 119, 120, /* 160 - 167 */
	121, 122, 161, 191, 64, 221, 91, 174, /* 168 - 175 */
	162, 163, 165, 183, 169, 167, 182, 188, /* 176 - 183 */
	189, 190, 172, 124, 175, 168, 92, 215, /* 184 - 191 */
	222, 65, 66, 67, 68, 69, 70, 71, /* 192 - 199 */
	72, 73, 173, 244, 126, 242, 243, 245, /* 200 - 207 */
	230, 74, 75, 76, 77, 78, 79, 80, /* 208 - 215 */
	81, 82, 185, 251, 252, 249, 250, 255, /* 216 - 223 */
	180, 247, 83, 84, 85, 86, 87, 88, /* 224 - 231 */
	89, 90, 178, 212, 94, 210, 211, 213, /* 232 - 239 */
	48, 49, 50, 51, 52, 53, 54, 55, /* 240 - 247 */
	56, 57, 179, 219, 220, 217, 218, 159, /* 248 - 255 */
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
