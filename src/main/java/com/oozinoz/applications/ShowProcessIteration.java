package com.oozinoz.applications;

import com.oozinoz.process.*;
import com.oozinoz.util.*;

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
 * Show a short program that prints the nodes of a composite, 
 * using indentation to show each node’s depth. The composite
 * that this program walks is the Oozinoz object model of
 * the process flow that creates aerial shells.
 * 
 * @author Steven J. Metsker 
 */
public class ShowProcessIteration 
{
/**
 * Show a short program that prints the nodes of a composite, 
 * using indentation to show each node’s depth.
 */
public static void main(String[] args)
{
	ProcessComponent pc = ShellProcess.make();
	ComponentIterator i = pc.iterator();
	while (i.hasNext())
	{
		for (int j = 0; j < i.depth() * 4; j++)
		{
			System.out.print(' ');
		}
		System.out.println(i.next());
	}
}
}