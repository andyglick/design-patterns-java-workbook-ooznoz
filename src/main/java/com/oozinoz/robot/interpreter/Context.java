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
 * This class contains a mapping of machine and variable
 * names to machine objects.
 * 
 * @author Steven J. Metsker
 */
public class Context 
{
	Map map = new HashMap();




/**
 * Map the given variable's name to the given machine.
 *
 * @param Variable the variable 
 * @param Machine the machine
 */
public void assign(Variable v, Machine m)
{
	map.put(v.name, m);
}

/**
 * Map the given name to the given machine.
 *
 * @param String the name of the machine
 * @param Machine the machine
 */
public void assign(String name, Machine m)
{
	map.put(name, m);
}

/**
 * Return the machine referred to by the provided name.
 *
 * @return the machine referred to by the provided name
 * @throws RuntimeException if no such name appears in the context
 */
public Machine lookup(String name)
{
	Machine m = (Machine) map.get(name);
	if (m == null)
	{
		throw new RuntimeException("Can't find machine " + name);
	}
	return m;
}



/**
 * Return all the machines in this context.
 *
 * @return all the (unique) machines in this context
 */
public Set getMachines()
{
	Set s = new HashSet();
	s.addAll(map.values());
	return s;
}
}