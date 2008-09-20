package org.webterm.core.plugin.authentication;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.log4j.Logger;
import org.webterm.core.configuration.ConfigurationReader;

/**
 * Provider for LDAP Authentication
 * 
 * @author charles
 */
public final class LdapAuthentication implements IAuthentication {

	/** Logger */
	private static final Logger LOG = Logger.getLogger(LdapAuthentication.class);

	/** Authentication method name */
	private static final String AUTH_METHOD = "ldap"; //$NON-NLS-1$

	/** Name of the configuration file in the ApplicationConfiguration.properties */
	private static final String CONFIG_SERVER_NAME = "AUTHENTICATION.LDAP.SERVER_NAME"; //$NON-NLS-1$

	/** Name of the configuration file in the ApplicationConfiguration.properties */
	private static final String CONFIG_SERVER_PORT = "AUTHENTICATION.LDAP.SERVER_PORT"; //$NON-NLS-1$

	/** Name of the configuration file in the ApplicationConfiguration.properties */
	private static final String CONFIG_BIND_DN = "AUTHENTICATION.LDAP.BIND_DN"; //$NON-NLS-1$

	/** Name of the configuration file in the ApplicationConfiguration.properties */
	private static final String CONFIG_BIND_PWD = "AUTHENTICATION.LDAP.BIND_PWD"; //$NON-NLS-1$

	/** Name of the configuration file in the ApplicationConfiguration.properties */
	private static final String CONFIG_BASE_DN = "AUTHENTICATION.LDAP.BASE_DN"; //$NON-NLS-1$

	/** Name of the configuration file in the ApplicationConfiguration.properties */
	private static final String CONFIG_ATTR_USER = "AUTHENTICATION.LDAP.ATTR_USER"; //$NON-NLS-1$

	/** Name of the configuration file in the ApplicationConfiguration.properties */
	private static final String CONFIG_ATTR_PWD = "AUTHENTICATION.LDAP.ATTR_PWD"; //$NON-NLS-1$

	/** LDAP Connection */
	private transient DirContext ldapContext;

	/** base DN for user search */
	private transient String baseDn;

	/** Attribute for login search */
	private transient String attrUser;

	/** Attribute for password search */
	private transient String attrPwd;

	/** Unique instance. */
	private static final LdapAuthentication instance = new LdapAuthentication();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static LdapAuthentication getInstance() {
		return instance;
	}

	/**
	 * Constructor
	 */
	private LdapAuthentication() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.authentication.IAuthentication#getAuthMethod()
	 */
	@Override
	public String getAuthMethod() {
		return AUTH_METHOD;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.authentication.IAuthentication#init()
	 */
	@Override
	public void init() {
		LOG.info("Initializing LDAP authentication..."); //$NON-NLS-1$

		try {
			final ConfigurationReader config = ConfigurationReader.getInstance();
			final String serverName = config.getApplicationProperty(CONFIG_SERVER_NAME);
			final String serverPort = config.getApplicationProperty(CONFIG_SERVER_PORT);
			final String bindDn = config.getApplicationProperty(CONFIG_BIND_DN);
			final String bindPwd = config.getApplicationProperty(CONFIG_BIND_PWD);
			this.baseDn = config.getApplicationProperty(CONFIG_BASE_DN);
			this.attrUser = config.getApplicationProperty(CONFIG_ATTR_USER);
			this.attrPwd = config.getApplicationProperty(CONFIG_ATTR_PWD);
			final Hashtable<String, String> ldapEnv = new Hashtable<String, String>(); //NOPMD - HashTable is needed
			ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); //$NON-NLS-1$
			ldapEnv.put(Context.PROVIDER_URL, "ldap://" + serverName + ":" + serverPort); //$NON-NLS-1$ //$NON-NLS-2$
			ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");//$NON-NLS-1$
			ldapEnv.put(Context.SECURITY_PRINCIPAL, bindDn);
			ldapEnv.put(Context.SECURITY_CREDENTIALS, bindPwd);
			this.ldapContext = new InitialDirContext(ldapEnv);
		} catch (Exception ex) {
			LOG.error(ex, ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.authentication.IAuthentication#isValidUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isValidUser(final String user, final String passwd) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Attribute reader
	 * 
	 * @param username
	 * @return Attributes associated with the login.
	 */
	public Attributes fetch(final String username) {
		Attributes attributes = null; //NOPMD - init
		try {
			final DirContext obj = (DirContext) this.ldapContext.lookup(this.attrUser + "=" + username + "," + this.baseDn); //$NON-NLS-1$ //$NON-NLS-2$
			attributes = obj.getAttributes(this.attrPwd);
			for (final NamingEnumeration<? extends Attribute> ae = attributes.getAll(); ae.hasMoreElements();) {
				final Attribute attr = ae.next();
				final String attrId = attr.getID(); //NOPMD
				for (final NamingEnumeration<?> vals = attr.getAll(); vals.hasMore();) {
					final String thing = vals.next().toString();
					LOG.info(attrId + ":" + thing); //$NON-NLS-1$
				}
			}
		} catch (Exception ex) {
			LOG.error(ex, ex);
		}
		return attributes;
	}
}
