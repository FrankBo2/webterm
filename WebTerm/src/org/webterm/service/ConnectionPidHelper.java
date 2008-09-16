package org.webterm.service;

/**
 * Helper for PID management.
 * 
 * @author charles
 */
public final class ConnectionPidHelper {

	/** unique instance*/
	private static final ConnectionPidHelper instance = new ConnectionPidHelper();
	
	/**
	 * Getter
	 * 
	 * @return Unique instance
	 */
	public static ConnectionPidHelper getInstance() {
		return instance;
	}
	
	/** cur PID value */
	private transient long pid = 0;
	
	/**
	 * Constructor
	 */
	private ConnectionPidHelper() {
		super();
	}
	
	/**
	 * Getter
	 * 
	 * @return New PID value
	 */
	public long getNewConnectionPid() {
		synchronized (instance) {
			return this.pid++;
		}
	}
}
