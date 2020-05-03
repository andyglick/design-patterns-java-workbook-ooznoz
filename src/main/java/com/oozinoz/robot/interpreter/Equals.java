package com.oozinoz.robot.interpreter;

import com.oozinoz.machine.*;

/*
 * Copyright (c) 2001 Steven J. Metsker.
 * 
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose, 
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */
/**
 * Represent a comparison of two terms.
 * 
 * @author Steven J. Metsker
 */
public class Equals extends Term 
{
	protected Term term1;
	protected Term term2;
/**
 * Construct a term that can compare the two provided terms.
 */
public Equals(Term term1, Term term2)
{
	this.term1 = term1;
	this.term2 = term2;
}
/**
 * Return null if this term's subterms evaluate to
 * different machines.
 *
 * @return null if this term's subterms evaluate to
 *         different machines. Otherwise return the
 *         machine.
 */
public Machine eval(Context c)
{
	Machine m1 = term1.eval(c);
	Machine m2 = term2.eval(c);
	boolean b = m1.toString().equals(m2.toString());
	return b ? m1 : null;
}
}