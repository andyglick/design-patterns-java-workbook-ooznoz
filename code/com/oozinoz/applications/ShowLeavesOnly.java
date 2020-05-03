package com.oozinoz.applications;

import com.oozinoz.util.*;
import com.oozinoz.process.*;

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
 * Show a short program that prints just the leaf nodes
 * of a (possibly cyclic) composite.
 * 
 * @author Steven J. Metsker
 * @see ShowProcessIteration
 */
public class ShowLeavesOnly 
{
/**
 * Show a short program that prints just the leaf nodes
 * of a (possibly cyclic) composite.
 */
public static void main(String[] args)
{
	ProcessComponent pc = ShellProcess.make();
	ComponentIterator i = pc.iterator();
	i.setShowInterior(false);
	while (i.hasNext())
	{
		System.out.println(i.next());
	}
}
}