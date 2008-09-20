package org.webterm.core.ebcdic.maps;

/**
 * Interface for EBCDIC converter
 * 
 * @author charles
 */
public interface ICharMap {

	/**
	 * Getter
	 * 
	 * @return IBM EBCDIC code
	 */
	int getServerIbmCode();
	
	/**
	 * Getter
	 * 
	 * @return Client char code
	 */
	String getClientCharCode();
	
	/**
	 * Getter
	 * 
	 * @return map for encoding
	 */
	char[] getEncoder();
	
	/**
	 * Getter
	 * 
	 * @return map for decoding
	 */
	char[] getDecoder();
}
