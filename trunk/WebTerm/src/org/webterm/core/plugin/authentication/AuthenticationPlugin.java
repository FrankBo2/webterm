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
package org.webterm.core.plugin.authentication;

import java.util.HashMap;
import java.util.Map;

import org.webterm.configuration.ConstConfiguration;
import org.webterm.core.plugin.IPlugin;
import org.webterm.service.AuthenticationService;

/**
 * Plug in for authentication management.
 * 
 * @author charles
 */
public final class AuthenticationPlugin implements IPlugin {

	/** Map for registered authentication provider */
	private transient final Map<String, IAuthentication> map = new HashMap<String, IAuthentication>();

	/** Unique instance. */
	private static final AuthenticationPlugin instance = new AuthenticationPlugin();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static AuthenticationPlugin getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private AuthenticationPlugin() {
		super();
		register(FileAuthentication.getInstance());
		register(LdapAuthentication.getInstance());
	}

	/**
	 * Registration method
	 * 
	 * @param provider Authentication provider to register
	 */
	private void register(final IAuthentication provider) {
		this.map.put(provider.getAuthMethod(), provider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.IPlugin#destroy()
	 */
	@Override
	public void destroy() {
		AuthenticationService.getInstance().setAuthProvider(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.IPlugin#init()
	 */
	@Override
	public void init() {
		AuthenticationService.getInstance().setAuthProvider(this.map.get(ConstConfiguration.AUTHENTICATION_METHODE));
	}
}
