package com.oozinoz.outside;

import com.oozinoz.simulation.*;
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
 * This class shows a devious way to access a class's
 * protected attributes.
 * 
 * @author Steven J. Metsker
 */
public class Burrow extends SolidRocket 
{
/**
 * Construct a solid rocket simulator from the given
 * attributes; but this class is just here to make a point
 * about protected attributes.
 */
public Burrow(
	String name,
	Speed burnRate,
	Area burnArea,
	Time burnTime,
	Acceleration specificImpulse,
	Density density)
{
	super(
		name,
		burnRate,
		burnArea,
		burnTime,
		specificImpulse,
		density);
}
/**
 * This changes the burn rate--illegally. The point here is
 * that we have created a subclass specifically to
 * manipulate the superclass's protected variables. 
 */
public void setBurnRate(Speed burnRate)
{
	this.burnRate = burnRate;
}
}