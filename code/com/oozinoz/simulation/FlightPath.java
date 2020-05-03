package com.oozinoz.simulation;

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
 * Represent a parabolic flight path of an object.
 * 
 * @author Steven J. Metsker
 */
public class FlightPath 
{
	protected double distance;
	protected double apogee;
/**
 * Construct a flight path in terms of how far and how high
 * the object will go.
 *
 * @param distance how far the object will go
 * @param apogee how high the object will go
 */
public FlightPath(double distance, double apogee)
{
	this.distance = distance;
	this.apogee = apogee;
}
/**
 * Return the x- values of the path.
 *
 * @return the x- values of the path
 */
public int[] getX(int nPoint)
{
	int[] x = new int[nPoint];
	for (int i = 0; i < nPoint; i++)
	{
		// t goes 0 to 1
		double t = ((double) i) / (nPoint - 1);
		// x goes 0 to distance
		x[i] = (int) (t * distance);
	}
	return x;
}
/**
 * Return the y- values of the path.
 *
 * @return the y- values of the path
 */
public int[] getY(int nPoint)
{
	int[] y = new int[nPoint];
	for (int i = 0; i < nPoint; i++)
	{
		// t goes 0 to 1
		double t = ((double) i) / (nPoint - 1);
		// y is apogee at t = 0 and t = 1, and y is 0 at t = .5
		y[i] = (int) (4 * apogee * (t - .5) * (t - .5));
	}
	return y;
}
}