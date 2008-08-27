package org.webterm.term;


/**
 * Interface for Term instantiation.
 * 
 * @author charles
 * @param <T>
 *            Type of terminal
 */
public interface ITermCreator<T extends AbstractTermDescription> {

	/**
	 * Getter
	 * 
	 * @return Type of terminal
	 */
	String getTermType();

	/**
	 * This methode provide a brand new instance of <T>.
	 * 
	 * @return New instance.
	 */
	T newInstance();
}
