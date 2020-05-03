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
 * This class is a particular type of measure with the
 * dimension of a constant (no length, mass, or time).
 *
 * @author Steve Metsker
 */
public class Constant extends Measure 
{
/**
 * Create a constant
 *
 * @param magnitude the constant's value
 */
public Constant(double magnitude)
{
	super(magnitude, CONSTANT);
}
}