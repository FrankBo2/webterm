/**
 * 
 */
package org.webterm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.webterm.core.ConstStruts;
import org.webterm.core.UserDescription;

/**
 * Service for session access.
 * 
 * @author charles
 */
public final class SessionService {

	/** Logger */
	private static final Logger LOG = Logger.getLogger(SessionService.class);

	/** unique instance */
	private static final SessionService instance = new SessionService();

	/**
	 * Getter
	 * 
	 * @return Unique instance
	 */
	public static SessionService getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private SessionService() {
		super();
	}

	/**
	 * Getter
	 * 
	 * @param request HTTP request
	 * @return UserDescription
	 */
	@SuppressWarnings("unchecked")
	public UserDescription getUserDescription(final HttpServletRequest request) {
		final HttpSession session = request.getSession();
		UserDescription user = null; // NOPMD - init
		try {
			if (session != null) {
				user = (UserDescription) session.getAttribute(ConstStruts.SESSION_USER_DESC);
			}
		} catch (final Exception ex) { // NOPMD
			LOG.error(ex, ex);
		}
		return user;
	}

	/**
	 * Setter
	 * 
	 * @param request HTTP request
	 * @param user UserDescription
	 */
	@SuppressWarnings("unchecked")
	public void setUserDescription(final HttpServletRequest request, final UserDescription user) {
		final HttpSession session = request.getSession();
		if (session != null) {
			session.setAttribute(ConstStruts.SESSION_USER_DESC, user);
		}
	}
}
