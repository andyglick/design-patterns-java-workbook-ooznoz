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
 * This simple planner assumes its machine is always up
 * and available.
 * 
 * @author Steven J. Metsker
 */
public class BasicPlanner extends MachinePlanner 
{
/**
 * Construct a new basic planner.
 */
public BasicPlanner(Machine machine)
{
	super(machine);
}
/**
 * Return now.
 *
 * @return now, since this class represents machines that 
 *         are always avialable
 */
public java.util.Date getAvailable()
{
	return new java.util.Date();
}
}