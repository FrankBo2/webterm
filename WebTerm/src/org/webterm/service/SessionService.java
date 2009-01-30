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
	public void setUserDescription(final HttpServletRequest request, final UserDescription user) {
		final HttpSession session = request.getSession();
		if (session != null) {
			session.setAttribute(ConstStruts.SESSION_USER_DESC, user);
		}
	}
}
