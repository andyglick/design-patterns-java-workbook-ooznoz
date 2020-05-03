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
 * Instances of this class represent problems that
 * arise when working with measures, such as adding
 * gallons to feet.
 *
 * @author Steve Metsker
 */
public class MeasureException extends RuntimeException 
{
/**
 * Constructs a MeasureException with no detail 
 * message.
 */
public MeasureException()
{
	super();
}
/**
 * Constructs a MeasureException with the 
 * specified detail message. 
 *
 * @param String the detail message.
 */
public MeasureException(String s)
{
	super(s);
}
}