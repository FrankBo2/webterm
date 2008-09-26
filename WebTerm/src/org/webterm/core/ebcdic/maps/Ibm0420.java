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
 * Class for IBM 0420 code
 * 
 * @author charles
 */
public final class Ibm0420 implements ICharMap {

	/** Unique instance. */
	private static final Ibm0420 instance = new Ibm0420();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static Ibm0420 getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private Ibm0420() {
		super();
	}

	/** IBM server code */
	private static final int SERVER_CODE = 420;

	/** client code */
	private static final String CLIENT_CODE = "ISO8859-6"; //$NON-NLS-1$

	/** IBM 420 */
	private static final char[] ENCODER = new char[] {

	0, 1, 2, 3, 55, 45, 46, 47, /* 0 - 7 */
	22, 5, 37, 11, 12, 13, 14, 15, /* 8 - 15 */
	16, 17, 18, 19, 60, 61, 50, 38, /* 16 - 23 */
	24, 25, 63, 39, 28, 29, 30, 31, /* 24 - 31 */
	64, 90, 127, 123, 91, 108, 80, 125, /* 32 - 39 */
	77, 93, 92, 78, 107, 96, 75, 97, /* 40 - 47 */
	240, 241, 242, 243, 244, 245, 246, 247, /* 48 - 55 */
	248, 249, 122, 94, 76, 126, 110, 111, /* 56 - 63 */
	124, 193, 194, 195, 196, 197, 198, 199, /* 64 - 71 */
	200, 201, 209, 210, 211, 212, 213, 214, /* 72 - 79 */
	215, 216, 217, 226, 227, 228, 229, 230, /* 80 - 87 */
	231, 232, 233, 100, 138, 205, 155, 109, /* 88 - 95 */
	104, 129, 130, 131, 132, 133, 134, 135, /* 96 - 103 */
	136, 137, 145, 146, 147, 148, 149, 150, /* 104 - 111 */
	151, 152, 153, 162, 163, 164, 165, 166, /* 112 - 119 */
	167, 168, 169, 83, 79, 204, 203, 7, /* 120 - 127 */
	32, 33, 34, 35, 36, 21, 6, 23, /* 128 - 135 */
	40, 41, 42, 43, 44, 9, 10, 27, /* 136 - 143 */
	48, 49, 26, 51, 52, 53, 54, 8, /* 144 - 151 */
	56, 57, 58, 59, 4, 20, 62, 255, /* 152 - 159 */
	65, 161, 89, 72, 74, 102, 157, 120, /* 160 - 167 */
	172, 224, 170, 225, 121, 202, 174, 84, /* 168 - 175 */
	176, 160, 178, 179, 180, 181, 182, 183, /* 176 - 183 */
	184, 185, 186, 192, 188, 87, 190, 208, /* 184 - 191 */
	106, 70, 71, 73, 82, 69, 85, 86, /* 192 - 199 */
	88, 98, 99, 101, 103, 105, 113, 115, /* 200 - 207 */
	116, 117, 118, 119, 128, 139, 141, 143, /* 208 - 215 */
	144, 154, 158, 219, 234, 221, 222, 223, /* 216 - 223 */
	68, 171, 173, 175, 177, 187, 189, 191, /* 224 - 231 */
	207, 218, 220, 235, 236, 237, 238, 239, /* 232 - 239 */
	81, 66, 112, 142, 95, 67, 140, 156, /* 240 - 247 */
	206, 114, 250, 251, 252, 253, 254, 159, /* 248 - 255 */
	};

	/** IBM 420 */
	private static final char[] DECODER = new char[] {

	0, 1, 2, 3, 156, 9, 134, 127, /* 0 - 7 */
	151, 141, 142, 11, 12, 13, 14, 15, /* 8 - 15 */
	16, 17, 18, 19, 157, 133, 8, 135, /* 16 - 23 */
	24, 25, 146, 143, 28, 29, 30, 31, /* 24 - 31 */
	128, 129, 130, 131, 132, 10, 23, 27, /* 32 - 39 */
	136, 137, 138, 139, 140, 5, 6, 7, /* 40 - 47 */
	144, 145, 22, 147, 148, 149, 150, 4, /* 48 - 55 */
	152, 153, 154, 155, 20, 21, 158, 26, /* 56 - 63 */
	32, 160, 241, 245, 224, 197, 193, 194, /* 64 - 71 */
	163, 195, 164, 46, 60, 40, 43, 124, /* 72 - 79 */
	38, 240, 196, 123, 175, 198, 199, 189, /* 80 - 87 */
	200, 162, 33, 36, 42, 41, 59, 244, /* 88 - 95 */
	45, 47, 201, 202, 91, 203, 165, 204, /* 96 - 103 */
	96, 205, 192, 44, 37, 95, 62, 63, /* 104 - 111 */
	242, 206, 249, 207, 208, 209, 210, 211, /* 112 - 119 */
	167, 172, 58, 35, 64, 39, 61, 34, /* 120 - 127 */
	212, 97, 98, 99, 100, 101, 102, 103, /* 128 - 135 */
	104, 105, 92, 213, 246, 214, 243, 215, /* 136 - 143 */
	216, 106, 107, 108, 109, 110, 111, 112, /* 144 - 151 */
	113, 114, 217, 94, 247, 166, 218, 255, /* 152 - 159 */
	177, 161, 115, 116, 117, 118, 119, 120, /* 160 - 167 */
	121, 122, 170, 225, 168, 226, 174, 227, /* 168 - 175 */
	176, 228, 178, 179, 180, 181, 182, 183, /* 176 - 183 */
	184, 185, 186, 229, 188, 230, 190, 231, /* 184 - 191 */
	187, 65, 66, 67, 68, 69, 70, 71, /* 192 - 199 */
	72, 73, 173, 126, 125, 93, 248, 232, /* 200 - 207 */
	191, 74, 75, 76, 77, 78, 79, 80, /* 208 - 215 */
	81, 82, 233, 219, 234, 221, 222, 223, /* 216 - 223 */
	169, 171, 83, 84, 85, 86, 87, 88, /* 224 - 231 */
	89, 90, 220, 235, 236, 237, 238, 239, /* 232 - 239 */
	48, 49, 50, 51, 52, 53, 54, 55, /* 240 - 247 */
	56, 57, 250, 251, 252, 253, 254, 159, /* 248 - 255 */
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
