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
 * dimension of mass.
 *
 * @author Steve Metsker
 * @see Acceleration
 */
public class Mass extends Measure 
{
/**
 * Create a measure of mass with the given magnitude, noting
 * that this is an MKS system. 
 *
 * @param magnitude the magnitude of this mass in
 *                  an MKS system
 */
public Mass(double magnitude)
{
	super(magnitude, MASS);
}
}