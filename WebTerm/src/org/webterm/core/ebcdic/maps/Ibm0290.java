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
 * Class for IBM 0290 code
 * 
 * @author charles
 */
public final class Ibm0290 implements ICharMap {

	/** Unique instance. */
	private static final Ibm0290 instance = new Ibm0290();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static Ibm0290 getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private Ibm0290() {
		super();
	}

	/** IBM server code */
	private static final int SERVER_CODE = 290;

	/** client code */
	private static final String CLIENT_CODE = "JIS_X0201"; //$NON-NLS-1$

	/** IBM 290 */
	private static final char[] ENCODER = new char[] {

	0, 1, 2, 3, 55, 45, 46, 47, /* 0 - 7 */
	22, 5, 37, 11, 12, 13, 14, 15, /* 8 - 15 */
	16, 17, 18, 19, 60, 61, 50, 38, /* 16 - 23 */
	24, 25, 63, 39, 28, 29, 30, 31, /* 24 - 31 */
	64, 90, 127, 123, 224, 108, 80, 125, /* 32 - 39 */
	77, 93, 92, 78, 107, 96, 75, 97, /* 40 - 47 */
	240, 241, 242, 243, 244, 245, 246, 247, /* 48 - 55 */
	248, 249, 122, 94, 76, 126, 110, 111, /* 56 - 63 */
	124, 193, 194, 195, 196, 197, 198, 199, /* 64 - 71 */
	200, 201, 209, 210, 211, 212, 213, 214, /* 72 - 79 */
	215, 216, 217, 226, 227, 228, 229, 230, /* 80 - 87 */
	231, 232, 233, 218, 91, 185, 155, 109, /* 88 - 95 */
	121, 178, 98, 99, 100, 101, 102, 103, /* 96 - 103 */
	104, 105, 106, 219, 221, 95, 203, 181, /* 104 - 111 */
	112, 113, 114, 115, 116, 117, 118, 119, /* 112 - 119 */
	120, 220, 184, 179, 79, 222, 161, 7, /* 120 - 127 */
	32, 33, 34, 35, 36, 21, 6, 23, /* 128 - 135 */
	40, 41, 42, 43, 44, 9, 10, 27, /* 136 - 143 */
	48, 49, 26, 51, 52, 53, 54, 8, /* 144 - 151 */
	56, 57, 58, 59, 4, 20, 62, 255, /* 152 - 159 */
	160, 65, 66, 67, 68, 69, 70, 71, /* 160 - 167 */
	72, 73, 81, 82, 83, 84, 85, 86, /* 168 - 175 */
	88, 129, 130, 131, 132, 133, 134, 135, /* 176 - 183 */
	136, 137, 138, 140, 141, 142, 143, 144, /* 184 - 191 */
	145, 146, 147, 148, 149, 150, 151, 152, /* 192 - 199 */
	153, 154, 157, 158, 159, 162, 163, 164, /* 200 - 207 */
	165, 166, 167, 168, 169, 170, 172, 173, /* 208 - 215 */
	174, 175, 186, 187, 188, 189, 190, 191, /* 216 - 223 */
	180, 225, 128, 183, 139, 171, 87, 176, /* 224 - 231 */
	89, 177, 234, 235, 236, 237, 238, 239, /* 232 - 239 */
	223, 192, 74, 205, 206, 207, 208, 156, /* 240 - 247 */
	182, 202, 250, 251, 252, 253, 254, 204, /* 248 - 255 */
	};

	/** IBM 290 */
	private static final char[] DECODER = new char[] {

	0, 1, 2, 3, 156, 9, 134, 127, /* 0 - 7 */
	151, 141, 142, 11, 12, 13, 14, 15, /* 8 - 15 */
	16, 17, 18, 19, 157, 133, 8, 135, /* 16 - 23 */
	24, 25, 146, 143, 28, 29, 30, 31, /* 24 - 31 */
	128, 129, 130, 131, 132, 10, 23, 27, /* 32 - 39 */
	136, 137, 138, 139, 140, 5, 6, 7, /* 40 - 47 */
	144, 145, 22, 147, 148, 149, 150, 4, /* 48 - 55 */
	152, 153, 154, 155, 20, 21, 158, 26, /* 56 - 63 */
	32, 161, 162, 163, 164, 165, 166, 167, /* 64 - 71 */
	168, 169, 242, 46, 60, 40, 43, 124, /* 72 - 79 */
	38, 170, 171, 172, 173, 174, 175, 230, /* 80 - 87 */
	176, 232, 33, 92, 42, 41, 59, 109, /* 88 - 95 */
	45, 47, 98, 99, 100, 101, 102, 103, /* 96 - 103 */
	104, 105, 106, 44, 37, 95, 62, 63, /* 104 - 111 */
	112, 113, 114, 115, 116, 117, 118, 119, /* 112 - 119 */
	120, 96, 58, 35, 64, 39, 61, 34, /* 120 - 127 */
	226, 177, 178, 179, 180, 181, 182, 183, /* 128 - 135 */
	184, 185, 186, 228, 187, 188, 189, 190, /* 136 - 143 */
	191, 192, 193, 194, 195, 196, 197, 198, /* 144 - 151 */
	199, 200, 201, 94, 247, 202, 203, 204, /* 152 - 159 */
	160, 126, 205, 206, 207, 208, 209, 210, /* 160 - 167 */
	211, 212, 213, 229, 214, 215, 216, 217, /* 168 - 175 */
	231, 233, 97, 123, 224, 111, 248, 227, /* 176 - 183 */
	122, 93, 218, 219, 220, 221, 222, 223, /* 184 - 191 */
	241, 65, 66, 67, 68, 69, 70, 71, /* 192 - 199 */
	72, 73, 249, 110, 255, 243, 244, 245, /* 200 - 207 */
	246, 74, 75, 76, 77, 78, 79, 80, /* 208 - 215 */
	81, 82, 91, 107, 121, 108, 125, 240, /* 216 - 223 */
	36, 225, 83, 84, 85, 86, 87, 88, /* 224 - 231 */
	89, 90, 234, 235, 236, 237, 238, 239, /* 232 - 239 */
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
