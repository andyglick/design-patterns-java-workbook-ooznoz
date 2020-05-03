package com.oozinoz.machine;

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
 * Show an error that occurs when a composite structure
 * that assumes it is a tree actually is not.
 * 
 * @author Steven J. Metsker
 */
public class ShowPlant 
{
/**
 * Show an error that occurs when a composite structure
 * that assumes it is a tree actually is not.
 */
public static void main(String[] args)
{
	MachineComponent c = OozinozFactory.plant();
	System.out.println(c.getMachineCount());
}
}