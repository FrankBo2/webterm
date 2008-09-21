/**
 * 
 */
package org.webterm.ui.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.webterm.service.SessionService;

/**
 * Tag for user check
 * 
 * @author charles
 */
public final class IfUserConnectedTag extends TagSupport {

	/**
	 * Constructor
	 */
	public IfUserConnectedTag() {
		super();
	}

	/** Class serial */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		return (SessionService.getInstance().getUserDescription((HttpServletRequest) this.pageContext.getRequest()) == null) ? SKIP_BODY : EVAL_BODY_INCLUDE;
	}

}
