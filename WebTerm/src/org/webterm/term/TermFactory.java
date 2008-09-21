package org.webterm.term;

import java.util.HashMap;
import java.util.Map;

import org.webterm.term.ascii.ibm3164.Ibm3164TermCreator;

/**
 * Factory for terminals.
 * 
 * @author charles
 */
public final class TermFactory {

	/** Map for registered creators */
	private transient final Map<String, ITermCreator<? extends AbstractTermDescription>> creators = new HashMap<String, ITermCreator<? extends AbstractTermDescription>>();

	/** Unique instance of the class */
	private static final TermFactory instance = new TermFactory();

	/**
	 * Getter
	 * 
	 * @return Unique instance of the class
	 */
	public static TermFactory getInstance() {
		return instance;
	}

	/**
	 * Register methode for creators.
	 * 
	 * @param creator
	 */
	private void register(final ITermCreator<? extends AbstractTermDescription> creator) {
		this.creators.put(creator.getTermType(), creator);
	}

	/**
	 * Constructor
	 */
	private TermFactory() {
		super();
		register(Ibm3164TermCreator.getInstance());
	}

	/**
	 * Creation methode for term description.
	 * 
	 * @param type Terminal type.
	 * @return A brand new instance of the terminal description if <i>type</i> is found in <i>creators</i>, null otherwidth.
	 */
	public AbstractTermDescription create(final String type) {
		final ITermCreator<? extends AbstractTermDescription> creator = this.creators.get(type);
		return creator == null ? null : creator.newInstance();
	}
}
