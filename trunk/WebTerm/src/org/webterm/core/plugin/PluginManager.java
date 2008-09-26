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
package org.webterm.core.plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.webterm.core.plugin.authentication.AuthenticationPlugin;

/**
 * Plug-in manager class
 * 
 * @author charles
 */
public final class PluginManager implements Filter {

	/** Class serial */
	private static final long serialVersionUID = 1L;

	/** Logger */
	private static final Logger LOG = Logger.getLogger(PluginManager.class);

	/** list of plug-in */
	private transient final List<IPlugin> list = new ArrayList<IPlugin>();
	
	/**
	 * Constructor
	 */
	public PluginManager() {
		super();
		register(AuthenticationPlugin.getInstance());
	}
	
	/**
	 * Registration method.
	 * 
	 * @param plugin plugin to register
	 */
	private void register(final IPlugin plugin) {
		this.list.add(plugin);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		LOG.info("Clearing WebTerm application"); //$NON-NLS-1$

		for (final IPlugin plugin : this.list) {
			plugin.init();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest arg0, final ServletResponse arg1, final FilterChain arg2) throws IOException, ServletException {
		// Nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(final FilterConfig arg0) throws ServletException {
		LOG.info("Initializing WebTerm application"); //$NON-NLS-1$

		for (final IPlugin plugin : this.list) {
			plugin.init();
		}
	}

}
