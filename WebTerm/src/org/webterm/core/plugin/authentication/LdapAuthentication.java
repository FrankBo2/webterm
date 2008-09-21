package org.webterm.core.plugin.authentication;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.webterm.configuration.ConfigurationReader;
import org.webterm.core.ConstString;

/**
 * Provider for LDAP Authentication
 * 
 * @author charles
 */
public final class LdapAuthentication implements IAuthentication {

	/**
	 * Method for plain password check
	 * 
	 * @author charles
	 */
	protected static class PlainPasswordCheck implements IAuthenticationCheck {

		/** PLAIN method */
		private static final String ENCODE_METHOD = "plain"; //$NON-NLS-1$

		/** Unique instance. */
		private static final PlainPasswordCheck inst = new PlainPasswordCheck();

		/**
		 * Getter
		 * 
		 * @return Unique instance.
		 */
		public static PlainPasswordCheck getInstance() {
			return inst;
		}

		/**
		 * Constructor
		 */
		private PlainPasswordCheck() {
			super();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.webterm.core.plugin.authentication.IAuthentication.IAuthenticationCheck#getEncodeMethod()
		 */
		@Override
		public String getEncodeMethod() {
			return ENCODE_METHOD;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.webterm.core.plugin.authentication.IAuthentication.IAuthenticationCheck#isValidPassword(java.lang.String, byte[])
		 */
		@Override
		public boolean isValidPassword(final String passwd, final byte[] pwdAttr) {
			final StringBuilder str = new StringBuilder();
			for (final byte ch : pwdAttr) {
				str.append((char) ch);
			}
			return str.toString().equals(passwd);
		}

	}

	/** Logger */
	private static final Logger LOG = Logger.getLogger(LdapAuthentication.class);

	/** Authentication method name */
	private static final String AUTH_METHOD = "ldap"; //$NON-NLS-1$

	/** Server name in the ApplicationConfiguration.properties */
	private static final String CONFIG_SERVER_NAME = "AUTHENTICATION.LDAP.SERVER_NAME"; //$NON-NLS-1$

	/** Server port in the ApplicationConfiguration.properties */
	private static final String CONFIG_SERVER_PORT = "AUTHENTICATION.LDAP.SERVER_PORT"; //$NON-NLS-1$

	/** Bind DN in the ApplicationConfiguration.properties */
	private static final String CONFIG_BIND_DN = "AUTHENTICATION.LDAP.BIND_DN"; //$NON-NLS-1$

	/** Bind password in the ApplicationConfiguration.properties */
	private static final String CONFIG_BIND_PWD = "AUTHENTICATION.LDAP.BIND_PWD"; //$NON-NLS-1$

	/** Base DN in the ApplicationConfiguration.properties */
	private static final String CONFIG_BASE_DN = "AUTHENTICATION.LDAP.BASE_DN"; //$NON-NLS-1$

	/** Attribute for the user login in the ApplicationConfiguration.properties */
	private static final String CONFIG_ATTR_USER = "AUTHENTICATION.LDAP.ATTR_USER"; //$NON-NLS-1$

	/** Attribute for the user password in the ApplicationConfiguration.properties */
	private static final String CONFIG_ATTR_PWD = "AUTHENTICATION.LDAP.ATTR_PWD"; //$NON-NLS-1$

	/** Encoding method name in the ApplicationConfiguration.properties */
	private static final String CONFIG_PASSWORD_ENCODE = "AUTHENTICATION.LDAP.PASSWORD_ENCODE"; //$NON-NLS-1$

	/** LDAP Connection */
	private transient DirContext ldapContext;

	/** Password check method map */
	private transient final Map<String, IAuthenticationCheck> map = new HashMap<String, IAuthenticationCheck>();

	/** base DN for user search */
	private transient String baseDn;

	/** Attribute for login search */
	private transient String attrUser;

	/** Attribute for password search */
	private transient String attrPwd;

	/** class for password check */
	private transient IAuthenticationCheck checkMethode = null;

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
		register(PlainPasswordCheck.getInstance());
	}

	/**
	 * Register method
	 * 
	 * @param mth Method
	 */
	private void register(final IAuthenticationCheck mth) {
		this.map.put(mth.getEncodeMethod(), mth);
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
			this.checkMethode = this.map.get(config.getApplicationProperty(CONFIG_PASSWORD_ENCODE));
			if (this.checkMethode == null) {
				LOG.fatal("unknown method: " + config.getApplicationProperty(CONFIG_PASSWORD_ENCODE)); //$NON-NLS-1$
			}

			final Hashtable<String, String> ldapEnv = new Hashtable<String, String>(); // NOPMD - HashTable is needed
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
		boolean result = false; // NOPMD - init

		final Attribute pwd = fetch(user);
		if ((pwd != null) && (this.checkMethode != null)) {
			try {
				final byte[] pwdAttr = (byte[]) pwd.get(0);
				result = this.checkMethode.isValidPassword(passwd, pwdAttr);
			} catch (final Exception ex) {
				LOG.error(ex, ex);
			}
		}
		return result;
	}

	/**
	 * Attribute reader
	 * 
	 * @param username
	 * @return Attribute password associated with the login.
	 */
	public Attribute fetch(final String username) {
		Attribute pwd = null; // NOPMD - init
		if (StringUtils.isNotBlank(username)) {
			try {
				final DirContext obj = (DirContext) this.ldapContext.lookup(this.attrUser + "=" + username + "," + this.baseDn); //$NON-NLS-1$ //$NON-NLS-2$
				final Attributes attributes = obj.getAttributes(ConstString.EMPTY);
				pwd = attributes.get(this.attrPwd);
			} catch (Exception ex) {
				LOG.error(ex, ex);
			}
		}
		return pwd;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.plugin.authentication.IAuthentication#destroy()
	 */
	@Override
	public void destroy() {
		try {
			this.ldapContext.close();
		} catch (final Exception ex) {
			LOG.error(ex, ex);
		}
	}
}
