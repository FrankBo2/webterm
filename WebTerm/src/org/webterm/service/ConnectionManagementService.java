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
package org.webterm.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.webterm.connections.ConnectionDescription;
import org.webterm.core.ConstMessages;
import org.webterm.service.forms.AbstractServiceRequest;
import org.webterm.service.forms.AbstractServiceResult.Status;
import org.webterm.service.forms.query.CreateConnectionRequest;
import org.webterm.service.forms.query.SimpleConnectionRequest;
import org.webterm.service.forms.result.ConnectionListResult;
import org.webterm.service.forms.result.SimpleConnectionResult;
import org.webterm.term.AbstractTermDescription;
import org.webterm.term.TermFactory;

/**
 * Service for Connection Management.
 * 
 * @author charles
 */
public final class ConnectionManagementService {

	/** Unique instance */
	private final static ConnectionManagementService instance = new ConnectionManagementService();

	/**
	 * Getter
	 * 
	 * @return Unique instance
	 */
	public static ConnectionManagementService getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private ConnectionManagementService() {
		super();
	}

	/** list of all process */
	private transient final Map<Long, ConnectionDescription> processList = new HashMap<Long, ConnectionDescription>();

	/**
	 * Method to get the list of connections from the user.
	 * 
	 * @param params Request parameters
	 * @param result Request result
	 */
	public void getConnexionList(final AbstractServiceRequest params, final ConnectionListResult result) {
		if (result.getStatus() == Status.OK) {
			final String userName = params.getLogin();
			if (StringUtils.isEmpty(userName)) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_NO_PARAMETER_USR_PWD);
			} else {
				for (final ConnectionDescription process : this.processList.values()) {
					if (userName.equalsIgnoreCase(process.getTerm().getOwner())){
						result.getProcessList().add(process);
					}
				}
				result.setMessage(ConstMessages.OK_GENERIC);
			}
		}
	}

	/**
	 * Method to create a term connection.
	 * 
	 * @param params Request parameters
	 * @param result Request result
	 */
	public void createTerm(final CreateConnectionRequest params, final SimpleConnectionResult result) {
		if (result.getStatus() == Status.OK) {
			final AbstractTermDescription process = TermFactory.getInstance().create(params.getType());
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_UNSUPPORTED_TYPE);
			} else {
				final Long pid = process.getPid();
				final ConnectionDescription connectionDescription = new ConnectionDescription(process);
				connectionDescription.setServerName(params.getServerName());
				connectionDescription.setPort(params.getServerPort());
				this.processList.put(pid, connectionDescription);
				result.setProcess(connectionDescription);
				result.setMessage(ConstMessages.OK_CREATED);
			}
		}
	}

	/**
	 * Method for closing the connection to the server.
	 * 
	 * @param params Request parameters
	 * @param result Request result
	 */
	public void closeConnexion(final SimpleConnectionRequest params, final SimpleConnectionResult result) {
		getConnection(params, result);
		if (result.getStatus() == Status.OK) {
			final ConnectionDescription process = result.getProcess();
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_NO_PROCESS);
			} else {
				// FIXME close the connection
				// result = $this->processList[$pid]->close();
				if (result.getStatus() == Status.OK) {
					this.processList.remove(process.getTerm().getPid());
				}
			}
		}
	}

	/**
	 * Method to get the process <code>pid</code> in the process List. This method check the user login/password and check if the corresponding, if exists,
	 * is owned by the current user.
	 * 
	 * @param params Request parameters
	 * @param result Request result
	 */
	private void getConnection(final SimpleConnectionRequest params, final SimpleConnectionResult result) {
		if (result.getStatus() == Status.OK) {
			final Long pid = Long.valueOf(params.getPid());
			if (pid == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_NO_PARAMETER_PID);
			} else {
				final ConnectionDescription connectionDescription = this.processList.get(pid);
				if (connectionDescription == null) {
					result.setStatus(Status.ERROR);
					result.setMessage(ConstMessages.ERR_NO_PROCESS);
				} else {
					final String userName = params.getLogin();
					if (connectionDescription.getTerm().getOwner().equalsIgnoreCase(userName)) {
						result.setProcess(connectionDescription);
					} else {
						result.setStatus(Status.ERROR);
						result.setMessage(ConstMessages.ERR_CONN_NOT_YOURS);
					}
				}
			}
		}
	}

	/**
	 * Method for closing the connection process. This method destroy the AbstractTermDescription object stored in the application server.
	 * 
	 * @param params Request parameters
	 * @param result Request result
	 */
	public void closeProcess(final SimpleConnectionRequest params, final SimpleConnectionResult result) {
		getConnection(params, result);
		if (result.getStatus() == Status.OK) {
			final ConnectionDescription process = result.getProcess();
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_NO_PROCESS);
			} else {
				// FIXME close the process
				// result = $this->processList[$pid]->close();
				if (result.getStatus() == Status.OK) {
					this.processList.remove(process.getTerm().getPid());
				}
			}
		}
	}

	/**
	 * Method to get the current screen on the connection.
	 * 
	 * @param params Request parameters
	 * @param result Request result
	 */
	public void getScreen(final SimpleConnectionRequest params, final SimpleConnectionResult result) {
		getConnection(params, result);
		if (result.getStatus() == Status.OK) {
			final ConnectionDescription process = result.getProcess();
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_NO_PROCESS);
			} else {
				// FIXME get the screen
				// result = $this->processList[$pid]->close();
				if (result.getStatus() == Status.OK) {
					this.processList.remove(process.getTerm().getPid());
				}
			}
		}
	}
}
