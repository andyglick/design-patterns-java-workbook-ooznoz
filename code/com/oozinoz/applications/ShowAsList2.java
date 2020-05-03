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
 * This class is a revision of ShowAsList that does not
 * crash.
 * 
 * @author Steven J. Metsker
 */
public class ShowAsList2 
{
/**
 * A revision of ShowAsList that does not crash.
 */
public static void main(String[] args)
{
	String[] names =
		new String[] { "Mixer", "Star Press", "Shell Assembler" };
	System.out.println(names);
	List L = new ArrayList(Arrays.asList(names));
	System.out.println(L);
	L.add("Fuser");
}
}