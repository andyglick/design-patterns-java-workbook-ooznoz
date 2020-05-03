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
 * Show the (normally irrelevant) type of an iterator.
 * 
 * @author Steven J. Metsker 
 */
public class ShowIterator 
{
/**
 * Show the (normally irrelevant) type of an iterator.
 */
public static void main(String[] args)
{
	List list =
		Arrays.asList(
			new String[] { "fountain", "rocket", "sparkler" });
	Iterator i = list.iterator();
	while (i.hasNext())
	{
		System.out.println(i.next());
	}
	System.out.println(i.getClass().getName());
}
}