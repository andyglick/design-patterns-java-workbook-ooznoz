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
 * Show how to use a mutex just long enough to clone a
 * collection before iterating over it.
 * 
 * @author Steven J. Metsker
 */
public class ShowConcurrentMutex2 implements Runnable 
{
	private ArrayList sourceList;  // note the type change
	private List synchList;  
protected void go()
{
	sourceList = upMachineNames();
	synchList = Collections.synchronizedList(sourceList);
	List copy;
	synchronized (synchList)
	{
		copy = (List) sourceList.clone();
	}
	Iterator i = copy.iterator();
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
/**
 * Show how to use a mutex just long enough to clone a
 * collection before iterating over it.
 */
public static void main(String[] args)
{
	new ShowConcurrentMutex2().go();
}
/**
 * Insert an element in the list, in a separate
 * thread.
 */
public void run()
{
	synchList.add(0, "Fuser1101");
}
protected static ArrayList upMachineNames() //note change in return type!
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