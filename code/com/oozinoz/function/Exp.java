package com.oozinoz.function;

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
 * Wrap the Math.exp() function around a given source.
 * 
 * @author Steven J. Metsker
 */
public class Exp extends Function 
{

/**
 * Construct a exponentiation function that decorates the 
 * provided source function.
 *
 * @param Function the source function that this function
 *                 wraps
 */
public Exp(Function f)
{
	super(f);
}
/**
 * Return Math.exp() applied to the source function's value
 * at time t.
 *
 * @param t the time function that goes 0 to 1 and that
 *          other functions use as a parameter
 *
 * @return Math.exp() applied to the source function's value
 *         at time t.
 */
public double f(double t)
{
	return Math.exp(source[0].f(t));
}
}