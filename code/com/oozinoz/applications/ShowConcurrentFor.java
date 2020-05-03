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
 * Show that a "synchronized" list does not ensure that
 * iteration over the list with a "for" loop is thread safe.
 * 
 * @author Steven J. Metsker
 * @see ShowConcurrentIterator
 */
public class ShowConcurrentFor implements Runnable 
{
	private List list;
protected void go()
{
	list = Collections.synchronizedList(upMachineNames());
	for (int i = 0; i < list.size(); i++)
	{
		if (i == 1)
		{ // simulate wake-up
			new Thread(this).start();
		}
		System.out.println(list.get(i));
	}
}
/**
 * Show that a "synchronized" list does not ensure that
 * iteration over the list is thread safe.
 */
public static void main(String[] args)
{
	new ShowConcurrentFor().go();
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