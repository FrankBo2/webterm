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
 * Class for IBM 0875 code
 * 
 * @author charles
 */
public final class Ibm0875 implements ICharMap {

	/** Unique instance. */
	private static final Ibm0875 instance = new Ibm0875();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static Ibm0875 getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private Ibm0875() {
		super();
	}

	/** IBM server code */
	private static final int SERVER_CODE = 875;

	/** client code */
	private static final String CLIENT_CODE = "ISO8859-7"; //$NON-NLS-1$

	/** IBM 875 */
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
	167, 168, 169, 192, 220, 208, 161, 7, /* 120 - 127 */
	32, 33, 34, 35, 36, 21, 6, 23, /* 128 - 135 */
	40, 41, 42, 43, 44, 9, 10, 27, /* 136 - 143 */
	48, 49, 26, 51, 52, 53, 54, 8, /* 144 - 151 */
	56, 57, 58, 59, 4, 20, 62, 255, /* 152 - 159 */
	253, 225, 222, 176, 206, 252, 223, 235, /* 160 - 167 */
	112, 251, 237, 238, 239, 202, 106, 207, /* 168 - 175 */
	144, 218, 234, 250, 160, 128, 113, 221, /* 176 - 183 */
	114, 115, 117, 254, 118, 219, 119, 120, /* 184 - 191 */
	180, 65, 66, 67, 68, 69, 70, 71, /* 192 - 199 */
	72, 73, 81, 82, 83, 84, 85, 86, /* 200 - 207 */
	87, 88, 116, 89, 98, 99, 100, 101, /* 208 - 215 */
	102, 103, 104, 105, 177, 178, 179, 181, /* 216 - 223 */
	184, 138, 139, 140, 141, 142, 143, 154, /* 224 - 231 */
	155, 156, 157, 158, 159, 170, 171, 172, /* 232 - 239 */
	173, 174, 186, 175, 187, 188, 189, 190, /* 240 - 247 */
	191, 203, 204, 205, 182, 183, 185, 236, /* 248 - 255 */
	};

	/** IBM 875 */
	private static final char[] DECODER = new char[] {

	0, 1, 2, 3, 156, 9, 134, 127, /* 0 - 7 */
	151, 141, 142, 11, 12, 13, 14, 15, /* 8 - 15 */
	16, 17, 18, 19, 157, 133, 8, 135, /* 16 - 23 */
	24, 25, 146, 143, 28, 29, 30, 31, /* 24 - 31 */
	128, 129, 130, 131, 132, 10, 23, 27, /* 32 - 39 */
	136, 137, 138, 139, 140, 5, 6, 7, /* 40 - 47 */
	144, 145, 22, 147, 148, 149, 150, 4, /* 48 - 55 */
	152, 153, 154, 155, 20, 21, 158, 26, /* 56 - 63 */
	32, 193, 194, 195, 196, 197, 198, 199, /* 64 - 71 */
	200, 201, 91, 46, 60, 40, 43, 33, /* 72 - 79 */
	38, 202, 203, 204, 205, 206, 207, 208, /* 80 - 87 */
	209, 211, 93, 36, 42, 41, 59, 94, /* 88 - 95 */
	45, 47, 212, 213, 214, 215, 216, 217, /* 96 - 103 */
	218, 219, 174, 44, 37, 95, 62, 63, /* 104 - 111 */
	168, 182, 184, 185, 210, 186, 188, 190, /* 112 - 119 */
	191, 96, 58, 35, 64, 39, 61, 34, /* 120 - 127 */
	181, 97, 98, 99, 100, 101, 102, 103, /* 128 - 135 */
	104, 105, 225, 226, 227, 228, 229, 230, /* 136 - 143 */
	176, 106, 107, 108, 109, 110, 111, 112, /* 144 - 151 */
	113, 114, 231, 232, 233, 234, 235, 236, /* 152 - 159 */
	180, 126, 115, 116, 117, 118, 119, 120, /* 160 - 167 */
	121, 122, 237, 238, 239, 240, 241, 243, /* 168 - 175 */
	163, 220, 221, 222, 192, 223, 252, 253, /* 176 - 183 */
	224, 254, 242, 244, 245, 246, 247, 248, /* 184 - 191 */
	123, 65, 66, 67, 68, 69, 70, 71, /* 192 - 199 */
	72, 73, 173, 249, 250, 251, 164, 175, /* 200 - 207 */
	125, 74, 75, 76, 77, 78, 79, 80, /* 208 - 215 */
	81, 82, 177, 189, 124, 183, 162, 166, /* 216 - 223 */
	92, 161, 83, 84, 85, 86, 87, 88, /* 224 - 231 */
	89, 90, 178, 167, 255, 170, 171, 172, /* 232 - 239 */
	48, 49, 50, 51, 52, 53, 54, 55, /* 240 - 247 */
	56, 57, 179, 169, 165, 160, 187, 159, /* 248 - 255 */
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
