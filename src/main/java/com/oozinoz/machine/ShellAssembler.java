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
 * A shell assembler assemebles stars, gunpowder and paper
 * casing into an aerial shell.
 *
 * @author Steven J. Metsker
 *
 */
public class ShellAssembler extends Machine 
{
/**
 * Return a planner that knows how shell assemblers operate
 * 
 * @return a planner for this machine
 */
public MachinePlanner createPlanner()
{
	return new ShellPlanner(this);
}



/**
 * Create an assembler with the given id and with the 
 * supplied parent machine.
 *
 * @param id the identity of this shell assembler 
 * @param parent the composite this machine belongs to
 */
public ShellAssembler(int id, MachineComponent parent)
{
	super(id, parent);
}



/**
 * Create an assembler with the given id.
 *
 * @param id the identity of this shell assembler 
 */
public ShellAssembler(int id)
{
	super(id);
}

/**
 * Create an assembler with the given id and with access to 
 * the mediator that will control bin/machine relations.
 *
 * @param id the identity of this shell assembler
 * @param Mediator the mediator that controls this machine's
 *                 relation to bins
 */
protected ShellAssembler(int id, Mediator mediator)
{
	this(id, mediator, null);
}

/**
 * Create an assembler with the given id, with access to 
 * the mediator that will control bin/machine relations, and
 * with the supplied parent machine.
 *
 * @param id the identity of this shell assembler
 * @param Mediator the mediator that controls this machine's
 *                 relation to bins
 * @param parent the composite this machine belongs to
 */
public ShellAssembler(
	int id,
	Mediator mediator,
	MachineComponent parent)
{
	super(id, mediator, parent);
}
}