/**
 * 
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
