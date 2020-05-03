package com.oozinoz.robot.interpreter;

import com.oozinoz.machine.*;

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
 * This class models a track robot that slides along a track
 * (a rail) and picks and places bins of material from
 * processing machines.
 * 
 * @author Steven J. Metsker
 */
public class Robot 
{
	private static final Robot robot = new Robot();
private Robot()
{
}
/**
 * Move to a machine, pick up a bin, move to another machine,
 * and place the bin.
 *
 * @param Machine the "from" machine
 * @param Machine the "to" machine
 */
public void carry(Machine m1, Machine m2)
{
	System.out.println(
		"Robot carrying from " + m1 + " to " + m2);
	Bin b = m1.unload();
	m2.addBin(b);
}
/**
 * Return a machine line's robot.
 *
 * @return a machine line's robot
 */
public static Robot getRobot()
{
	return robot;
}
}