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
 * This class is just here to show a bad thing that can
 * happen when you use protected visibility. See the
 * "Responsibility" chapter in "The Design Patterns Java
 * Workbook."
 * 
 * @author Steven J. Metsker
 */
public class SolidRocket implements RocketSim 
{
	protected String name;
	protected Speed burnRate;
	protected Area burnArea;
	protected Time burnTime;
	protected Acceleration specificImpulse;
	protected Density density;
/**
 * Construct a solid rocket simulator from the given
 * attributes; but this class is just here to make a point
 * about protected attributes.
 */
public SolidRocket(
	String name,
	Speed burnRate,
	Area burnArea,
	Time burnTime,
	Acceleration specificImpulse,
	Density density)
{
	//
	this.name = name;
	this.burnRate = burnRate;
	this.burnArea = burnArea;
	this.burnTime = burnTime;
	this.specificImpulse = specificImpulse;
	this.density = density;
	// calculate and save thrust
	thrust =
		(Force) burnRate
			.times(burnArea)
			.times(burnTime)
			.times(specificImpulse)
			.times(density);
}
/**
 * This method in fact returns null.
 */
public Length apogee()
{
	return null;
}
/**
 * Return the simulated thrust for this rocket.
 *
 * @return the simulated thrust for this rocket
 */
public Force thrust()
{
	return thrust;
}

	protected Force thrust;
}