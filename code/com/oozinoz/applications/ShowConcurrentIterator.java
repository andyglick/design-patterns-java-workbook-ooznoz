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
 * Show that modifying a list while an iterator iterates
 * over it causes an exception.
 * 
 * @author Steven J. Metsker
 * @see ShowConcurrentMutex
 */
public class ShowConcurrentIterator implements Runnable 
{
	private List list;
protected void go()
{
	list = Collections.synchronizedList(upMachineNames());
	Iterator i = list.iterator();
	int j = 0;
	while (i.hasNext())
	{
		j++;
		if (j == 1)
		{ // simulate wake-up
			new Thread(this).start();
		}
		System.out.println(i.next());
	}
}
/**
 * Show that modifying a list while an iterator iterates
 * over it causes an exception.
 */
public static void main(String[] args)
{
	new ShowConcurrentIterator().go();
}
/**
 * Insert an element in the list, in a separate
 * thread.
 */
public void run()
{
	list.add(0, "Fuser1101");
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