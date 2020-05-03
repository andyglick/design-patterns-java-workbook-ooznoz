package com.oozinoz.simulation;

import com.oozinoz.fireworks.*;
import com.oozinoz.units.*;

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
 * Shows how a class can adapt an existing the interface of
 * an existing class (Shell) to implement another interface
 * (RocketSim).
 * 
 * @author Steven J. Metsker
 */
public class ShellAsRocket
extends Shell
implements RocketSim 
{
/**
 * Make a shell look like a rocket. Sort of.
 *
 * @param String the rocket's name
 * @param double the price
 */
public ShellAsRocket(String name, double price)
{
	super(name, price);
}
/**
 * Return the height that a shell will attain (a function of
 * its muzzle velocity). This code is not actually 
 * implemented here.
 *
 * @return the height that a shell will attain (a function 
 *         of its muzzle velocity).
 */
public Length apogee()
{
	return null;
}
/**
 * Return the "thrust" that a shell receives from its
 * initial launch. Not actually implemented here.
 *
 * @return the "thrust" that a shell receives from its
 *         initial launch. 
 */
public Force thrust()
{
	return null;
}
}