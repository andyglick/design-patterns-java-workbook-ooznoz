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
 * This class crashes when its main() method attempts to
 * add an item to a List object created by Arrays.asList().
 * The point here is an exploration of the Liskov Substitution
 * Principle. Does LSP allow a class to implement some methods 
 * in an interface so that the methods always throw an
 * exception?
 * 
 * @author Steven J. Metsker
 */
public class ShowAsList 
{
/**
 * Explore of the Liskov Substitution Principle, noting that
 * this method throws an unhandled exception.
 */
public static void main(String[] args)
{
	String[] names =
		new String[] { "Mixer", "Star Press", "Shell Assembler" };
	System.out.println(names);
	List L = Arrays.asList(names);
	System.out.println(L);
	L.add("Fuser");
}
}