/**
 * 
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
