package org.webterm.term.ascii.ibm3164;

import org.webterm.term.ITermCreator;

/**
 * Creator for IBM 3164 terminals.
 * 
 * @author charles
 */
public final class Ibm3164TermCreator implements ITermCreator<Ibm3164TermDescription> {

	/** Unic instance of the class */
	private static final Ibm3164TermCreator instance = new Ibm3164TermCreator();

	/**
	 * Getter
	 * 
	 * @return Unic instance of the class
	 */
	public static Ibm3164TermCreator getInstance() {
		return instance;
	}

	/**
	 * Constructor.
	 */
	private Ibm3164TermCreator() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.ITermCreator#getTermType()
	 */
	@Override
	public String getTermType() {
		return ConstIbm3164.TERM_TYPE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.webterm.core.ITermCreator#newInstance()
	 */
	@Override
	public Ibm3164TermDescription newInstance() {
		return new Ibm3164TermDescription();
	}

}
