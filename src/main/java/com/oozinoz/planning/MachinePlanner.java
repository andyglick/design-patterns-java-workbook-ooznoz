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
 * Objects of this class can forecast the future (to a degree)
 * for a machine.
 * 
 * @author Steven J. Metsker
 */
public abstract class MachinePlanner 
{
	protected Machine machine;
/**
 * Construct a new planner for the provided machine.
 *
 * @param Machine the machine to plan for
 */
public MachinePlanner(Machine machine)
{
	this.machine = machine;
}
/**
 * When are we planning for this machine next become 
 * available?
 */
public abstract java.util.Date getAvailable();
}