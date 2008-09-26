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
package org.webterm.core;

import java.util.Calendar;
import java.util.Date;

import org.webterm.service.forms.AbstractServiceRequest;

/**
 * Class for User description in the session
 * 
 * @author charles
 */
public final class UserDescription extends AbstractServiceRequest {

	/** Connection date */
	private Date connectionDate;

	/**
	 * Constructor
	 */
	public UserDescription() {
		super();
		this.connectionDate = Calendar.getInstance().getTime();
	}

	/**
	 * @return the connectionDate
	 */
	public Date getConnectionDate() {
		return this.connectionDate;
	}

	/**
	 * @param connectionDate the connectionDate to set
	 */
	public void setConnectionDate(final Date connectionDate) {
		this.connectionDate = connectionDate;
	}
}
