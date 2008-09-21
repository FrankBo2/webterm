/**
 * 
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
