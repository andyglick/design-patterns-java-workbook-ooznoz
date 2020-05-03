package com.oozinoz.dublin;

import com.oozinoz.machine.*;
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
 * This class uses the visitor mechanics of the machine
 * hierarchy to add a behavior that finds a particular
 * machine within a machine composite.
 * 
 * @author Steven J. Metsker
 * @see com.oozinoz.applications.ShowFind
 */
public class FindVisitor implements MachineVisitor 
{
	private MachineComponent sought;
	private int soughtId;
/**
 * Finds a machine with the given id, within the 
 * given machine composite.
 *
 * @param MachineComponent the composite to look within
 * @param id the id of the machine to find
 * @return a machine with the given id, within the 
 *         given machine composite
 */
public MachineComponent find(MachineComponent mc, int id)
{
	sought = null;
	soughtId = id;
	mc.accept(this);
	return sought;
}
/**
 * Check a particular machine to see if it's the one
 * that is sought.
 */
public void visit(Machine m)
{
	if (sought == null && m.getId() == soughtId)
	{
		sought = m;
	}
}
/**
 * Check if the provided composite is the sought machine
 * component. If not, check this composite's children.
 */
public void visit(MachineComposite mc)
{
	if (sought == null && mc.getId() == soughtId)
	{
		sought = mc;
		return;
	}
	Iterator i = mc.getComponents().iterator();
	while (sought == null && i.hasNext())
	{
		((MachineComponent) i.next()).accept(this);
	}
}
}