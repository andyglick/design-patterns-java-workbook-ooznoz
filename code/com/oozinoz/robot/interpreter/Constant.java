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
 * Represent a specific machine.
 * 
 * @author Steven J. Metsker
 */
public class Constant extends Term 
{
	protected Machine machine;
/**
 * Construct a term that always referst to a specific
 * machine.
 */
public Constant(Machine machine)
{
	this.machine = machine;
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
	if (!(o instanceof Constant))
		return false;
	Constant c = (Constant) o;
	return machine.equals(c.machine);
}
/**
 * Return this term's machine, ignoring the context.
 *
 * @return this term's machine, ignoring the context
 */
public Machine eval(Context c)
{
	return machine;
}
}