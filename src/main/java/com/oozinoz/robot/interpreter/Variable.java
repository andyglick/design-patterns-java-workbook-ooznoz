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
 * Record a name that can be used to assign and look up 
 * machines in a context (or mapping).
 * 
 * @author Steven J. Metsker
 */
public class Variable extends Term 
{
	protected String name;
/**
 * Construct a variable with the provided name.
 */
public Variable(String name)
{
	this.name = name;
}
/**
 * Return true if the provided object equals this one.
 *
 * @return true if the provided object equals this one
 */
public boolean equals(Object o)
{
	if (o == this)
		return true;
	if (!(o instanceof Variable))
		return false;
	Variable v = (Variable) o;
	return name.equals(v.name);
}
/**
 * Return the machine that this variable refers to in
 * the provide context.
 *
 * @param Context the mapping in which to look up this
 *                variable's name
 * @return the machine that this variable refers to in
 *         the provide context.
 */
public Machine eval(Context c)
{
	return c.lookup(name);
}
}