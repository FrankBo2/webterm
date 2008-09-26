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
package org.webterm.ui.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.webterm.core.UserDescription;
import org.webterm.service.SessionService;

/**
 * Tag for user name display
 * 
 * @author charles
 */
public final class UserNameTag extends TagSupport {

	/**
	 * Constructor
	 */
	public UserNameTag() {
		super();
	}

	/** Class serial */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		final UserDescription user = SessionService.getInstance().getUserDescription((HttpServletRequest) this.pageContext.getRequest());
		if (user != null) {
			try {
				this.pageContext.getOut().print(user.getLogin());
			} catch (final IOException ex) {
				throw new JspException(ex);
			}
		}
		return SKIP_BODY;
	}

}
