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
 * dimension of area.
 *
 * @author Steve Metsker
 * @see Acceleration
 */
public class Area extends Measure 
{
/**
 * Create an area with the given magnitude, noting
 * that this is an MKS system. 
 *
 * @param magnitude the magnitude of this area in
 *                  an MKS system
 */
public Area(double magnitude)
{
	super(magnitude, AREA);
}
}