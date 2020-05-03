package com.oozinoz.simulation;

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
 * This class demonstrates the benefits of proper cloning.
 * 
 * @author Steven J. Metsker
 */
public class ShowCloningFixed implements UnitConstants 
{
/**
 * This class demonstrates the benefits of proper cloning.
 */
public static void main(String[] args)
{
	// Mixer 1 is in bay 1, at coordinate(15m, 25m)
	Length x = (Length) METER.times(15);
	Length y = (Length) METER.times(25);
	Location loc = new Location(1, x, y);
	// 10 hours mean-time-to-repair
	MixerSimulator m1 =
		new MixerSimulator(loc, (Time) HOUR.times(10));
	MixerSimulator m2 = (MixerSimulator) m1.clone();
	// Mixer 2 is in bay 2, at coordinate (20, 75)
	m2.location.setBay(2);
	m2.location.setCoordinates(
		(Length) METER.times(20),
		(Length) METER.times(75));
	System.out.println(m1.location.bay);
}
}