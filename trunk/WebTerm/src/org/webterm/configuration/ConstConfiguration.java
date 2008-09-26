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

/**
 * Configuration reader
 * 
 * @author charles
 */
public final class ConstConfiguration {

	/**
	 * Constructor
	 */
	private ConstConfiguration() {
		super();
	}

	/** Declare the authentication method */
	public static final String AUTHENTICATION_METHODE;

	/** Navigator title */
	public static final String APPLICATION_TITLE;

	/** Application theme */
	public static final String APPLICATION_THEME;

	static {
		final ConfigurationReader conf = ConfigurationReader.getInstance();
		AUTHENTICATION_METHODE = conf.getApplicationProperty("AUTHENTICATION.METHODE"); //$NON-NLS-1$
		APPLICATION_TITLE = conf.getApplicationProperty("APPLICATION.TITLE"); //$NON-NLS-1$
		APPLICATION_THEME = conf.getApplicationProperty("APPLICATION.THEME"); //$NON-NLS-1$
	}
}
