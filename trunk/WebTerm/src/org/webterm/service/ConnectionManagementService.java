package org.webterm.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.webterm.core.ConstMessages;
import org.webterm.service.ServiceResult.Status;
import org.webterm.service.forms.CreateConnectionRequest;
import org.webterm.service.forms.SimpleConnectionRequest;
import org.webterm.service.forms.result.SimpleConnectionResult;
import org.webterm.term.AbstractTermDescription;
import org.webterm.term.TermFactory;

/**
 * Service for Connextion Management.
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
	private Map<Long, AbstractTermDescription> processList = new HashMap<Long, AbstractTermDescription>();

	public void getConnexionList(final AbstractServiceRequest params, final ServiceResult result) {
		isValidUser(params, result);

		if (result.getStatus() == Status.OK) {
			// $userName = (string) $params->userName;
			final StringBuilder str = new StringBuilder();
			str.append("\r\n");
			str.append("\t\t<user>$userName</user>\r\n");
			str.append("\t\t<connexionList>\r\n");

			for (final AbstractTermDescription process : processList.values()) {
				// if (process->owner == $userName) {
				str.append("\t\t\t<connexion>\r\n");
				str.append("\t\t\t\t<pid>" + process.getPid().toString() + "</pid>\r\n");
				str.append("\t\t\t\t<status>" + process.getConnectionDescription().getConnectionStatus() + "</status>\r\n");
				str.append("\t\t\t\t<server>" + process.getConnectionDescription().getServerName() + "</server>\r\n");
				str.append("\t\t\t\t<port>" + process.getConnectionDescription().getPort() + "</port>\r\n");
				str.append("\t\t\t</connexion>\r\n");
				// }
			}

			str.append("\t\t</connexionList>\r\n\t");
			result.setMessage(str.toString());
		}
	}

	public void createTerm(final CreateConnectionRequest params, final ServiceResult result) {
		isValidUser(params, result);

		if (result.getStatus() == Status.OK) {
			final String userName = params.getUserName();

			AbstractTermDescription term = TermFactory.getInstance().create(params.getType());
			if (term == null) {
				result.setStatus(Status.ERROR);
				result.setMessage("Unsupported type");
			} else {
				final Long pid = term.getPid();
				processList.put(pid, term);
				term.getConnectionDescription().setServerName(params.getServerName());
				term.getConnectionDescription().setPort(params.getServerPort());
				// term.getConnectionDescription().

				result.setMessage("\r\n" + "\t\t<user>" + userName + "</user>\r\n" + "\t\t<pid>" + pid.toString() + "</pid>\r\n\t");
			}
		}
	}

	/**
	 * Methode for the user password check.
	 * 
	 * @param params Request params
	 * @param result Request result
	 */
	public void isValidUser(final AbstractServiceRequest params, final ServiceResult result) {
		result.setStatus(Status.ERROR);
		result.setMessage("Parameters 'userName' and 'userPassword' needed...");

		final String userName = params.getUserName();
		final String userPassword = params.getUserPassword();

		if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(userPassword)) {

			if (userName.equalsIgnoreCase("charles") && userPassword.equals("Ker%29H")) {
				result.setStatus(Status.OK);
				result.setMessage("\r\n" + "\t\t<user>" + userName + "</user>\r\n\t");
			} else {
				result.setMessage("Invalid login/password...");
			}
		}
	}

	/**
	 * Methode for closing the connection to the server.
	 * 
	 * @param params Request params
	 * @param result Request result
	 */
	public void closeConnexion(final SimpleConnectionRequest params, final SimpleConnectionResult result) {
		getConnection(params, result);
		if (result.getStatus() == Status.OK) {
			final AbstractTermDescription process = result.getProcess();
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.NO_PROCESS);
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
	 * Methode to get the process <code>pid</code> in the process List. This methode check the user login/password and check if the corresponding, if exists,
	 * is owned by the current user.
	 * 
	 * @param params Request params
	 * @param result Request result
	 */
	private void getConnection(final SimpleConnectionRequest params, final SimpleConnectionResult result) {
		isValidUser(params, result);
		if (result.getStatus() == Status.OK) {
			final String userName = params.getUserName();
			final Long pid = Long.valueOf(params.getPid());
			if (pid == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.NO_PARAMETER_PID);
			} else {
				final AbstractTermDescription term = this.processList.get(pid);
				if (term == null) {
					result.setStatus(Status.ERROR);
					result.setMessage(ConstMessages.NO_PROCESS);
				} else {
					if (term.getOwner().equalsIgnoreCase(userName)) {
						result.setProcess(term);
					} else {
						result.setStatus(Status.ERROR);
						result.setMessage(ConstMessages.CONNECTION_NOT_YOURS);
					}
				}
			}
		}
	}

	/**
	 * Methode for closing the connection process. This methode destroy the AbstractTermDescription object stored in the application server.
	 * 
	 * @param params Request params
	 * @param result Request result
	 */
	public void closeProcess(final SimpleConnectionRequest params, final SimpleConnectionResult result) {
		getConnection(params, result);
		if (result.getStatus() == Status.OK) {
			final AbstractTermDescription process = result.getProcess();
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.NO_PROCESS);
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
	 * Methode to get the current screnn on the connection.
	 * 
	 * @param params Request params
	 * @param result Request result
	 */
	public void getScreen(final SimpleConnectionRequest params, final SimpleConnectionResult result) {
		getConnection(params, result);
		if (result.getStatus() == Status.OK) {
			final AbstractTermDescription process = result.getProcess();
			if (process == null) {
				result.setStatus(Status.ERROR);
				result.setMessage(ConstMessages.NO_PROCESS);
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
