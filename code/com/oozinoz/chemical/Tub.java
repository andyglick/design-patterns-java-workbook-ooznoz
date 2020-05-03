package com.oozinoz.chemical;

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
 * A tub is a standard, rubber container that contains
 * about four liters of a chemical. This class is a minimal
 * model that helps show how to manage a one-to-many
 * relation in an object model.
 *
 * @author Steven J. Metsker
 *
 */
public class Tub 
{
	protected String id;
	protected Mediator mediator;
/**
 * Create a tub with the given id and managed by the given
 * mediator.
 *
 * @param id the identity of this tub
 * @param Mediator the mediator that manages Tub/Machine
 *                 relations
 */
public Tub(String id, Mediator mediator)
{
	this.id = id;
	this.mediator = mediator;
}
/**
 * Return the machine at which this tub is placed
 *
 * @return the machine at which this tub is placed
 */
public Machine getMachine()
{
	return mediator.getMachine(this);
}
/**
 * Set the location of this tub
 *
 * @param machine the location of this tub, the machine at
 *                which the tub is placed
 */
public void setMachine(Machine machine)
{
	mediator.set(this, machine);
}
/**
 * Return a textual representation of this tub.
 *
 * @return a textual representation of this tub
 */
public String toString()
{
	return id;
}
}