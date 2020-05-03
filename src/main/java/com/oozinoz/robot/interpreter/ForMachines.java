package com.oozinoz.robot.interpreter;

import java.util.*;
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
 * This class represents a "for" loop that will execute its
 * body for each machine in a context, assigning a provided
 * variable to a different machine in each pass through the 
 * loop.
 * 
 * @author Steven J. Metsker
 */
public class ForMachines extends Command 
{
	protected Variable variable;
	protected Command body;
/**
 * Construct a "for" interpreter that will execute the
 * provided body, looping through the machines in a context,
 * assigning the provided variable to each machine.
 *
 * @param Variable the variable to assign to machines in a
 *                 context
 * @param Command the command to execute in each pass of the
 *                loop
 */
public ForMachines(Variable variable, Command body)
{
	this.variable = variable;
	this.body = body;
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
	if (!(o instanceof ForMachines))
		return false;
	ForMachines fm = (ForMachines) o;
	return variable.equals(fm.variable)
		&& body.equals(fm.body);
}
/**
 * For each machine in the context, assign this object's
 * variable to the machine, and execute this object's
 * body.
 */
public void execute(Context c)
{
	Iterator i = c.getMachines().iterator();
	while (i.hasNext())
	{
		Machine m = (Machine) i.next();
		c.assign(variable, m);
		body.execute(c);
	}
}
}