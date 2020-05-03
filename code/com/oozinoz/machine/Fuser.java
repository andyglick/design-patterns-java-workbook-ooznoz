package com.oozinoz.machine;

import com.oozinoz.planning.*;

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
 * A fuser inserts fusing in an aerial shell.
 *
 * @author Steven J. Metsker
 *
 */
public class Fuser extends Machine 
{
/**
 * Return a basic planner, since our fusers are pretty
 * predictable.
 * 
 * @return a basic planner
 */
public MachinePlanner createPlanner()
{
	return new BasicPlanner(this);
}

/**
 * Create a fuser with the given id and with the given
 * parent
 *
 * @param id the identity of this fuser
 * @param parent the composite this machine belongs to
 */
public Fuser(int id, MachineComponent parent)
{
	super(id, parent);
}

/**
 * Create a fuser with the given id
 *
 * @param id the identity of this fuser
 */
public Fuser(int id)
{
	super(id);
}

/**
 * Create a fuser with the given id and with access to the
 * mediator that will control bin/machine relations
 *
 * @param id the identity of this fuser
 * @param Mediator the mediator that controls this machine's
 *                 relation to bins
 */
protected Fuser(int id, Mediator mediator)
{
	this(id, mediator, null);
}

/**
 * Create a fuser with the given id, with access to the
 * mediator that will control bin/machine relations, and
 * with the given parent machine component
 *
 * @param id the identity of this fuser
 * @param Mediator the mediator that controls this machine's
 *                 relation to bins
 * @param parent the composite this machine belongs to
 */
public Fuser(
	int id,
	Mediator mediator,
	MachineComponent parent)
{
	super(id, mediator, parent);
}
}