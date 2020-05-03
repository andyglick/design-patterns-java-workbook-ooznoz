package com.oozinoz.planning;

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
 * This planner predicts when a shell assembler will become
 * available. A complete implementation would probably
 * consider the availability of raw materials and personnel,
 * as well as considering the up time characteristics of
 * the machine.
 * 
 * @author Steven J. Metsker
 */
public class ShellPlanner extends MachinePlanner 
{
/**
 * Construct a new planner for a shell assembler.
 */
public ShellPlanner(ShellAssembler machine)
{
	super(machine);
}
/**
 * Return a datetime when the shell assembler that this 
 * planner represents will next become available. 
 *
 * @return Date when the shell assembler that this 
 *              planner represents will next become 
 *              available. In practice, this method would 
 *              employ some operational modeling logic 
 *              to determine this time.
 */
public java.util.Date getAvailable()
{
	// just return the current time, in this example
	return new java.util.Date();
}
}