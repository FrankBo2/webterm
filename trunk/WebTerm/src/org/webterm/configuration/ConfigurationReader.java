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
package org.webterm.configuration;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.webterm.core.ConstString;

/**
 * Class in charge of configuration file read.
 * 
 * @author charles
 */
public final class ConfigurationReader {

	/** Logger */
	private static final Logger LOG = Logger.getLogger(ConfigurationReader.class);

	/** Name of the configuration file */
	private static final String applicationBundle = "org.webterm.configuration.ApplicationConfiguration"; //$NON-NLS-1$

	/** Unique instance. */
	private static final ConfigurationReader instance = new ConfigurationReader();

	/**
	 * Getter
	 * 
	 * @return Unique instance.
	 */
	public static ConfigurationReader getInstance() {
		return instance;
	}

	/** configuration bundle */
	private transient final ResourceBundle bundle;

	/**
	 * Constructor
	 */
	private ConfigurationReader() {
		super();
		ResourceBundle tmp = null; // NOPMD - init
		try {
			tmp = ResourceBundle.getBundle(applicationBundle, Locale.getDefault(), Thread.currentThread().getContextClassLoader());
		} catch (final MissingResourceException e) {
			LOG.fatal("No resourceBundle : " + applicationBundle); //$NON-NLS-1$
		}
		this.bundle = tmp;
	}

	/**
	 * Configuration Key/Value reader.
	 * 
	 * @param key Name of the key in the configuration file.
	 * @return value of the <code>key</code> or null if not found.
	 */
	public String getApplicationProperty(final String key) {
		String result = ConstString.EMPTY; //NOPMD - initialization
		try {
			result = this.bundle.getString(key);
		} catch (final MissingResourceException ex) {
			LOG.error(ex, ex);
		}
		return result;
	}
}
