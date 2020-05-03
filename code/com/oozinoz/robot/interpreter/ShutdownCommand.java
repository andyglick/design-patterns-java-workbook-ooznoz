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
 * This class represents a command to shut down a machine
 * indicated by a provided term.
 * 
 * @author Steven J. Metsker
 */
public class ShutdownCommand extends Command 
{
	protected Term term;
/**
 * Construct a command to shut down a machine indicated by 
 * the provided term.
 *
 * @param Term a term to evaulate when this command executes;
 *             the machine it evaulates to will be shut down 
 */
public ShutdownCommand(Term term)
{
	this.term = term;
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
	if (!(o instanceof ShutdownCommand))
		return false;
	ShutdownCommand sc = (ShutdownCommand) o;
	return term.equals(sc.term);
}
/**
 * Evaluate this object's term to a machine and shut down
 * that machine.
 */
public void execute(Context c)
{
	Machine m = term.eval(c);
	m.shutdown();
}
}