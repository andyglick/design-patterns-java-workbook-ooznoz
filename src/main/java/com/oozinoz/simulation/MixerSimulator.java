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
 * Instances of this class simulate the mixers that make
 * paste for stars and other firework components.
 * 
 * @author Steven J. Metsker
 */
public class MixerSimulator extends MachineSimulator 
{
/**
 * Construct a simulator at the given location and with
 * the supplied mean time between failure.
 *
 * @param Location where is this (simulated) machine?
 * @param mtbf mean time between failure
 */
public MixerSimulator(Location location, Time mtbf)
{
	super(location, mtbf);
}
}