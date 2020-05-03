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
 * Represent the condition that a machine, referred to through
 * a term, is not empty.
 * 
 * @author Steven J. Metsker
 */
public class HasMaterial extends Term 
{
	protected Term term;
/**
 * Construct a term that represent a boolean function
 * regarding whether the term refers to a machine that
 * has material.
 */
public HasMaterial(Term term)
{
	this.term = term;
}
/**
 * Return null if this term's subterm evaluates to
 * a machine that has no material.
 *
 * @return null if this term's subterm evaluates to
 *         a machine that has no material. Otherwise
 *         return the machine.
 *
 */
public Machine eval(Context c)
{
	Machine m = term.eval(c);
	return m.hasMaterial() ? m : null;
}
}