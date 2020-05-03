package com.oozinoz.units;

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
 * This interface records constants that model dimensions
 * of physical quantities.
 *
 * @author Steve Metsker
 */
public interface DimensionConstants {
	// fundamental dimensions
	Dimension CONSTANT = new Dimension(0, 0, 0);
	Dimension LENGTH = new Dimension(1, 0, 0);
	Dimension MASS = new Dimension(0, 1, 0);
	Dimension TIME = new Dimension(0, 0, 1);
	// derived dimensions
	Dimension AREA = LENGTH.times(LENGTH);
	Dimension VOLUME = AREA.times(LENGTH);
	Dimension SPEED = LENGTH.divide(TIME);
	Dimension ACCELERATION = SPEED.divide(TIME);
	Dimension FORCE = MASS.times(ACCELERATION);
	Dimension PRESSURE =
		FORCE.divide(LENGTH).divide(LENGTH);
	Dimension ENERGY = FORCE.times(LENGTH);
	Dimension POWER = ENERGY.divide(TIME);
	Dimension DENSITY = MASS.divide(VOLUME);
}