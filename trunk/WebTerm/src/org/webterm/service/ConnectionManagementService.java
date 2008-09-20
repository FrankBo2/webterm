package org.webterm.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.webterm.core.ConstMessages;
import org.webterm.service.AbstractServiceResult.Status;
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
	private transient final Map<Long, AbstractTermDescription> processList = new HashMap<Long, AbstractTermDescription>();

	/**
	 * Method to get the list of connections from the user.
	 * 
	 * @param params Request parameters
	 * @param result Request result
	 */
	public void getConnexionList(final AbstractServiceRequest params, final ConnectionListResult result) {
		checkUser(params, result);

		if (result.getStatus() == Status.OK) {
			final String userName = params.getUserName();
			if (StringUtils.isEmpty(userName)) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_NO_PARAMETER_USR_PWD);
			} else {
				for (final AbstractTermDescription process : this.processList.values()) {
					if (userName.equalsIgnoreCase(process.getOwner())){
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
		checkUser(params, result);

		if (result.getStatus() == Status.OK) {
			final AbstractTermDescription process = TermFactory.getInstance().create(params.getType());
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_UNSUPPORTED_TYPE);
			} else {
				final Long pid = process.getPid();
				this.processList.put(pid, process);
				process.getConnectionDescription().setServerName(params.getServerName());
				process.getConnectionDescription().setPort(params.getServerPort());
				// process.getConnectionDescription().
				result.setProcess(process);
				result.setMessage(ConstMessages.OK_CREATED);
			}
		}
	}

	/**
	 * Method for the user password check.
	 * 
	 * @param params Request parameters
	 * @param result Request result
	 */
	public void checkUser(final AbstractServiceRequest params, final AbstractServiceResult result) {
		final String userName = params.getUserName();
		final String userPassword = params.getUserPassword();

		if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(userPassword)) {
			//FIXME auth methode
			if ("charles".equalsIgnoreCase(userName) && "Ker%29H".equals(userPassword)) { //$NON-NLS-1$ //$NON-NLS-2$
				result.setStatus(Status.OK);
				result.setMessage(ConstMessages.OK_AUTHENTICATED);
			} else {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_BAD_AUTH);
			}
		} else {
			result.setStatus(Status.ERROR);
			result.setMessage(ConstMessages.ERR_NO_PARAMETER_USR_PWD);
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
			final AbstractTermDescription process = result.getProcess();
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_NO_PROCESS);
			} else {
				// FIXME close the connection
				// result = $this->processList[$pid]->close();
				if (result.getStatus() == Status.OK) {
					this.processList.remove(process.getPid());
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
		checkUser(params, result);
		if (result.getStatus() == Status.OK) {
			final Long pid = Long.valueOf(params.getPid());
			if (pid == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_NO_PARAMETER_PID);
			} else {
				final AbstractTermDescription term = this.processList.get(pid);
				if (term == null) {
					result.setStatus(Status.ERROR);
					result.setMessage(ConstMessages.ERR_NO_PROCESS);
				} else {
					final String userName = params.getUserName();
					if (term.getOwner().equalsIgnoreCase(userName)) {
						result.setProcess(term);
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
			final AbstractTermDescription process = result.getProcess();
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_NO_PROCESS);
			} else {
				// FIXME close the process
				// result = $this->processList[$pid]->close();
				if (result.getStatus() == Status.OK) {
					this.processList.remove(process.getPid());
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
			final AbstractTermDescription process = result.getProcess();
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.ERR_NO_PROCESS);
			} else {
				// FIXME get the screen
				// result = $this->processList[$pid]->close();
				if (result.getStatus() == Status.OK) {
					this.processList.remove(process.getPid());
				}
			}
		}
	}
}
