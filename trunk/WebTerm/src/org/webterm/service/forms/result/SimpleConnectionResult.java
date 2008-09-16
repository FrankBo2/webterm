package org.webterm.service.forms.result;

import org.webterm.service.AbstractServiceResult;
import org.webterm.term.AbstractTermDescription;

/**
 * Simple result form for process request.
 * 
 * @author charles
 */
public class SimpleConnectionResult extends AbstractServiceResult {

	/** requested process */
	private AbstractTermDescription process;

	/**
	 * Getter
	 * 
	 * @return the process
	 */
	public AbstractTermDescription getProcess() {
		return this.process;
	}

	/**
	 * Setter
	 * 
	 * @param process the process to set
	 */
	public void setProcess(final AbstractTermDescription process) {
		this.process = process;
	}

}
