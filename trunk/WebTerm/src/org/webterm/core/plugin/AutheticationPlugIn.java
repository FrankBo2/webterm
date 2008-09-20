/**
 * 
 */
package org.webterm.core.plugin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.webterm.core.configuration.ConstConfiguration;
import org.webterm.core.plugin.authentication.AuthenticationProvider;
import org.webterm.core.plugin.authentication.FileAuthentication;
import org.webterm.core.plugin.authentication.IAuthentication;
import org.webterm.core.plugin.authentication.LdapAuthentication;

/**
 * Plug in for authentication management.
 * 
 * @author charles
 */
public final class AutheticationPlugIn implements PlugIn {

	/** Map for registered authentication provider */
	private transient final Map<String, IAuthentication> map = new HashMap<String, IAuthentication>();
	
	/**
	 * Constructor
	 */
	public AutheticationPlugIn() {
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
	 * @see org.apache.struts.action.PlugIn#destroy()
	 */
	@Override
	public void destroy() {
		//Nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.PlugIn#init(org.apache.struts.action.ActionServlet, org.apache.struts.config.ModuleConfig)
	 */
	@Override
	public void init(final ActionServlet arg0, final ModuleConfig arg1) throws ServletException {
		AuthenticationProvider.getInstance().setAuthProvider(this.map.get(ConstConfiguration.AUTHENTICATION_METHODE));
	}
}
