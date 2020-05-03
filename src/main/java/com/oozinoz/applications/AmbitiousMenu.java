package com.oozinoz.applications;

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
 * 
 * This (dysfunctional) class shows a method from an overly 
 * ambitious menu that figures out who the responsible engineer 
 * is for a piece of equipment. In the "Chain of Responsibility" 
 * chapter of "The Design Patterns Java Workbook," this code is 
 * refactored so that the domain objects determine who is the 
 * responsible engineer. 
 * 
 * @author Steven J. Metsker
 */
public class AmbitiousMenu 
{
/** 
 * Return the engineer that is responsible for the machine
 * or tool that a simulated item represents.
 *
 * @return the engineer that is responsible for the machine
 *         or tool that a simulated item represents.
 */
public Engineer getResponsible(SimulatedItem item)
{
	if (item instanceof Tool)
	{
		Tool t = (Tool) item;
		return t.getToolCart().getResponsible();
	}
	if (item instanceof MachineComponent)
	{
		MachineComponent c = (MachineComponent) item;
		if (c.getResponsible() == null)
		{
			if (c.getParent() != null)
			{
				return c.getParent().getResponsible();
			}
		}
	}
	return null;
}
}