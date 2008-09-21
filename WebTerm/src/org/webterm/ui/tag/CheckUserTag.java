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
public final class CheckUserTag extends TagSupport {

	/**
	 * Constructor
	 */
	public CheckUserTag() {
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
	public int doEndTag() throws JspException {
		return (SessionService.getInstance().getUserDescription((HttpServletRequest) this.pageContext.getRequest()) == null) ? SKIP_PAGE : EVAL_PAGE;
	}

}
