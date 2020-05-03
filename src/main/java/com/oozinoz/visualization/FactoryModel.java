package com.oozinoz.visualization;

import java.util.*;

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
 * This class supports a visualization (a picture) of
 * an Oozinoz factory.
 * 
 * @author Steven J. Metsker
 */
public class FactoryModel 
{
	protected List machines = new ArrayList();


/**
 * Return true if this model has no machines.
 *
 * @return true if this model has no machines
 */
public boolean isEmpty()
{
	return machines.isEmpty();
}


/**
 * Add a (simulated) machine to this (simulated) factory.
 *
 * @param MachineImage the machine to add
 */
public void addMachine(MachineImage machine)
{
	machines.add(machine);
}

/**
 * Create a list of MachineImage clones that record the
 * state of the simulation at this time.
 *
 * @return a list of MachineImage clones that record the
 *         state of the simulation at this time.
 */
public List createMemento()
{
	List list = new ArrayList();
	Iterator i = machines.iterator();
	while (i.hasNext())
	{
		MachineImage mi = (MachineImage) i.next();
		list.add(mi.clone());
	}
	return list;
}

/**
 * Return the machines in this factory model.
 *
 * @return the machines in this factory model
 */
public List getMachines()
{
	return machines;
}

/**
 * Reset the state of this simulation to the state recorded
 * in the provided list.
 *
 * @param List a list of MachineImage clones
 */
public void restore(List memento)
{
	machines = new ArrayList();
	Iterator i = memento.iterator();
	while (i.hasNext())
	{
		MachineImage mi = (MachineImage) i.next();
		machines.add(mi.clone());
	}
}
}