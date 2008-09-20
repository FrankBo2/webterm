/**
 * 
 */
package org.webterm.core.plugin;

/**
 * Interface for custom plug-in. The goal is to load and initialize classes at the webapp startup.
 * 
 * @author charles
 */
public interface IPlugin {

	/**
	 * Initialize configuration
	 */
	void init();
	
	/**
	 * Destroy configuration
	 */
	void destroy();
}
