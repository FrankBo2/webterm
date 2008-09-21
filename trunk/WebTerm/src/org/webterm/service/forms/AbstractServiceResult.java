package org.webterm.service.forms;

/**
 * Généric response for service request.
 * 
 * @author charles
 */
public abstract class AbstractServiceResult { // NOPMD - no abstract methode

	/**
	 * Enum for the result Status.
	 * 
	 * @author charles
	 */
	public enum Status {
		/** Ok */
		OK,
		/** error */
		ERROR;
	}

	/** Response status */
	private Status status = Status.ERROR;

	/** Response Message */
	private String message;

	/**
	 * Getter
	 * 
	 * @return the status
	 */
	public Status getStatus() {
		return this.status;
	}

	/**
	 * Setter
	 * 
	 * @param status the status to set
	 */
	public void setStatus(final Status status) {
		this.status = status;
	}

	/**
	 * Getter
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Setter
	 * 
	 * @param message the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}
}
