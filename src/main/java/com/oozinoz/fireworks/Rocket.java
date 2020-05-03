package com.oozinoz.fireworks;

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
 * A self-propelled firework.
 * 
 * @author Steven J. Metsker
 */
public class Rocket extends Firework 
{
	protected Length apogee;
	protected Speed burnRate;








/**
 * Return a textual representation of this rocket.
 * 
 * @return a textual representation of this rocket
 */
public String toString()
{
	return name + " $" + price + " (" + apogee + ")";
}

/**
 * Make a rocket.
 *
 * @param String the rocket's name
 * @param double the price
 * @param Length the apogee; the greatest altitude this
 *                rocket is likely to attain
 */
public Rocket(String name, double price, Length apogee)
{
	super(name, price);
	this.apogee = apogee;
}

/**
 * @see Firework#flies()
 */
public static boolean flies()
{
	return true;
}

/**
 * Return this rocket's apogee.
 *
 * @return this rocket's apogee, the greatest altitude that
 *         is expected to attain
 */
public Length getApogee()
{
	return apogee;
}
}