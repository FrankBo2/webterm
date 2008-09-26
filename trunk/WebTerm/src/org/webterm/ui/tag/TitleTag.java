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
