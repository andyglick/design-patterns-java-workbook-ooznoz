package com.oozinoz.applications;

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
 * Show that a "mutex" object--an object whose monitor is
 * used for mutual exclusion--can provide safe iteration
 * over a collection in a multi-threaded environment.
 * 
 * @author Steven J. Metsker
 * @see ShowConcurrentMutex2
 */
public class ShowConcurrentMutex implements Runnable 
{
	private List list;
	private Object mutex = new Object();
protected void go()
{
	list = upMachineNames();
	synchronized (mutex)
	{
		Iterator i = list.iterator();
		int j = 0;
		while (i.hasNext())
		{
			j++;
			if (j == 1)
			{
				new Thread(this).start();
			}
			System.out.println(i.next());
		}
	}
}
/**
 * Show that a "mutex" object--an object whose monitor is
 * used for mutual exclusion--can provide safe iteration
 * over a collection in a multi-threaded environment.
 */
public static void main(String[] args)
{
	new ShowConcurrentMutex().go();
}
/**
 * Insert an element in the list, in a separate
 * thread.
 */
public void run()
{
	synchronized (mutex)
	{
		list.add(0, "Fuser1101");
	}
}
protected static List upMachineNames()
{
	return new ArrayList(
		Arrays.asList(
			new String[] {
				"Mixer1201",
				"ShellAssembler1301",
				"StarPress1401",
				"UnloadBuffer1501" }));
}
}