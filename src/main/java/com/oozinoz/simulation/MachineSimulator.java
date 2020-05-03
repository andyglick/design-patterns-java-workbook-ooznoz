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
 * Instances of this class act like real machines but don't
 * actually drive physical equipment.
 * 
 * @author Steven J. Metsker
 */
public abstract class MachineSimulator
implements Cloneable 
{
	protected Location location;

/**
 * Return a copy of this simulator.
 *
 * @return a copy of this simulator
 */
public Object clone()
{
	try
	{
		MachineSimulator copy = (MachineSimulator) super.clone();
		copy.location = (Location) location.clone();
		return copy;
	}
	catch (CloneNotSupportedException e)
	{
		// this shouldn't happen, since we are Cloneable
		throw new InternalError();
	}
}

	protected Time mtbf;

/**
 * Construct a simulator at the given location and with
 * the supplied mean time between failure.
 *
 * @param Location where is this (simulated) machine?
 * @param mtbf the time expected to elapse from the time
 *             this machine comes up to the time it fails
 */
public MachineSimulator(Location location, Time mtbf)
{
	this.location = location;
	this.mtbf = mtbf;
}



/**
 * Return a copy of this simulator.
 *
 * @return a copy of this simulator, but note that there's
 *         a defect in this code that we have to fix
 */
public Object clone_1()
{
	try
	{
		return super.clone();
	}
	catch (CloneNotSupportedException e)
	{
		// this shouldn't happen, since we are Cloneable
		throw new InternalError();
	}
}
}