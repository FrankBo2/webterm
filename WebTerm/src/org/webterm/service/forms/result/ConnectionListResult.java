package org.webterm.service.forms.result;

import java.util.ArrayList;
import java.util.List;

import org.webterm.service.AbstractServiceResult;
import org.webterm.term.AbstractTermDescription;

/**
 * Form for the getConnectionList service request.
 * 
 * @author charles
 */
public class ConnectionListResult extends AbstractServiceResult {

	/** the list of process */
	private transient final List<AbstractTermDescription> processList = new ArrayList<AbstractTermDescription>();

	/**
	 * Getter
	 * 
	 * @return the processList
	 */
	public List<AbstractTermDescription> getProcessList() {
		return this.processList;
	} 
}
