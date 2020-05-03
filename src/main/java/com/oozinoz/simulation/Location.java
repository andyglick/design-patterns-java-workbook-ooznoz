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
 * Represent the location of a machine. 
 * 
 * @author Steven J. Metsker
 */
public class Location implements Cloneable 
{
	protected int bay;
	protected Length x;
	protected Length y;
/**
 * Construct a location for the given bay and x- and y-
 * position. Note that in simulations bays are identified
 * by number and are not treated as machine composites.
 *
 * @param int which bay is this location in?
 * @param Length the x offset from the northwest corner of 
 *               the bay; this length may be supplied in
 *               any units.
 * @param Length the y offset
 */
public Location(int bay, Length x, Length y)
{
	this.bay = bay;
	this.x = x;
	this.y = y;
}
/**
 * Return a copy of this location.
 *
 * @return a copy of this location
 */
public Object clone()
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
/**
 * Change the bay of this location.
 *
 * @param int the new bay's number
 */
public void setBay(int bay)
{
	this.bay = bay;
}
/**
 * Change the (x, y) position of this location
 *
 * @param Length the new x offset
 * @param Length the new y offset
 */
public void setCoordinates(Length x, Length y)
{
	this.x = x;
	this.y = y;
}
/**
 * Return a textual representation of this location.
 *
 * @return a textual representation of this location
 */
public String toString()
{
	return "Bay: " + bay + " (" + x + ", " + y + ")";
}
}