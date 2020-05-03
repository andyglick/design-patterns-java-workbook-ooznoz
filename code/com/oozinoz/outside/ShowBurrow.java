package com.oozinoz.outside;

import com.oozinoz.units.Acceleration;
import com.oozinoz.units.Area;
import com.oozinoz.units.Density;
import com.oozinoz.units.Speed;
import com.oozinoz.units.Time;
import com.oozinoz.units.UnitConstants;

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
 * This class uses the devious Burrow class to alter a
 * SolidRocket simulation's protected attributes.
 * 
 * @author Steven J. Metsker
 */
public class ShowBurrow implements UnitConstants 
{
/**
 * This just demonstrates the creation of a SolidRocket
 * simulation using the subclass Burrow. The subclass lets
 * us alter the burn rate directly, although this winds up
 * creating a problem that the superclass avoids.
 */
public static void main(String[] args)
{
	// Establish a rocket's attibrutes. As it happens these
	// are pretty realistic values.
	Speed burnRate =
		(Speed) MILLIMETER.times(40).divide(SECOND);
	Area burnArea = (Area) CM.times(CM).times(100);
	Time burnTime = SECOND;
	Acceleration specificImpulse =
		(Acceleration) NEWTON.times(1200).divide(KILOGRAM);
	Density density =
		(Density) KILOGRAM.times(2400).divide(M).divide(
			M).divide(
			M);
	// Create a simulation of rocket
	Burrow b =
		new Burrow(
			"JSquirrel",
			burnRate,
			burnArea,
			burnTime,
			specificImpulse,
			density);
	// Change the burn rate, which we can do only because
	// we're using Burrow, not SolidRocket
	b.setBurnRate(
		(Speed) MILLIMETER.times(38).divide(SECOND));
}
}