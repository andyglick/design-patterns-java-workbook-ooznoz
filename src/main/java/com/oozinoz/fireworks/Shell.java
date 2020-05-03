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
 * A firework designed to be launched from a mortar and 
 * explode high in the sky.
 * 
 * @author Steven J. Metsker
 */
public class Shell extends Firework 
{
/**
 * Make a shell.
 *
 * @param String the rocket's name
 * @param double the price
 */
public Shell(String name, double price)
{
	super(name, price);
}

/**
 * Return the speed at which this shell will leave its
 * mortar.
 *
 * @return the speed at which this shell will leave its
 *         mortar
 *
 * This code is not implemented. It's just here to show an
 * example in the "Adapter" chapter.
 */
public Speed muzzleVelocity()
{
	return null;
}
}