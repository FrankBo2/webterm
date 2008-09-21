/**
 * 
 */
package org.webterm.ui.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;
import org.webterm.configuration.ConstConfiguration;

/**
 * Tag for title display
 * 
 * @author charles
 */
public final class TitleTag extends TagSupport {

	/**
	 * Constructor
	 */
	public TitleTag() {
		super();
	}
	
	/** Logger */
	private static final Logger LOG = Logger.getLogger(TitleTag.class);

	/** Class serial */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		try {
			this.pageContext.getOut().print(ConstConfiguration.APPLICATION_TITLE);
		} catch (final Exception ex) {
			LOG.error(ex, ex);
		}
		return EVAL_PAGE;
	}
}
