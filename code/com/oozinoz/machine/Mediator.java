package com.oozinoz.machine;

import java.util.*;

import com.oozinoz.chemical.Tub;

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
 * This class manages the relation of tubs to machines.
 *
 * @author Steven J. Metsker
 *
 */
public class Mediator 
{




	protected Map tubToMachine = new HashMap();

/**
 * Return the machine where a tub is placed.
 *
 * @param Tub the tub
 * @return the machine where a tub is placed
 */
public Machine getMachine(Tub t)
{
	return (Machine) tubToMachine.get(t);
}

/**
 * Return a set of the tubs at a machine.
 *
 * @param Machine the machine
 * @return a set of the tubs at a machine
 */
public Set getTubs(Machine m)
{
	Set set = new HashSet();
	Iterator i = tubToMachine.entrySet().iterator();
	while (i.hasNext())
	{
		Map.Entry e = (Map.Entry) i.next();
		if (e.getValue().equals(m))
		{
			set.add(e.getKey());
		}
	}
	return set;
}

/**
 * Set a tub's location to be the given machine.
 *
 * @param Tub the tub
 * @param Machine the machine
 */
public void set(Tub t, Machine m)
{
	tubToMachine.put(t, m);
}
}