package org.webterm.term;

import org.webterm.connections.ConnectionDescription;

/**
 * Abstract class form Term description
 * 
 * @author charles
 */
public abstract class AbstractTermDescription {

	/** Name of the Terminal. */
	private String termName;
	
	/** Desciption of ther term connection. */
	private ConnectionDescription connectionDescription = new ConnectionDescription();
	
	/**
	 * Getter
	 * 
	 * @return Name of the Terminal.
	 */
	public final String getTermName() {
		return this.termName;
	}
	
	/**
	 * Getter
	 * 
	 * @return The Connection description.
	 */
	public final ConnectionDescription getConnectionDescription() {
		return this.connectionDescription;
	}
	
	/**
	 * Constructor
	 * 
	 * @param termName Name of the Terminal.
	 */
	protected AbstractTermDescription(final String termName) {
		this.termName = termName;
	}
}
