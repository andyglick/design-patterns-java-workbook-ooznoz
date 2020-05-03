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
 * dimension of acceleration. 
 *
 * You shouldn't normally use this class's constructor, 
 * preferring instead to use the units math built into this 
 * package. 
 * <p>
 * For example, a testing routine might create and check 
 * an acceleration as follows:
 * <blockquote><pre>
 *     Acceleration a =
 *         (Acceleration)
 *             FEET.times(32.17).divide(SECOND).divide(SECOND);
 *     assertEquals(G.dimension(), a.dimension());
 *     assertEquals(G.magnitude(), a.magnitude(), .01);
 * </pre></blockquote>
 *
 * Note that G, the acceleration due to the Earth's gravity,
 * is one of many units that UnitConstants supplies.
 *
 * @author Steve Metsker
 */
public class Acceleration extends Measure 
{
/**
 * Create an acceleration with the given magnitude, noting
 * that this is an MKS system. 
 *
 * @param magnitude the magnitude of this acceleration in
 *                  an MKS system
 */
public Acceleration(double magnitude)
{
	super(magnitude, ACCELERATION);
}
}