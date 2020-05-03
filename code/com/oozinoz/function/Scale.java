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
 * Represent a linear value that goes from one value to
 * another as time goes 0 to 1.
 * 
 * @author Steven J. Metsker
 */
public class Scale extends Function 
{
	protected char operator;
/**
 * Construct a Scale that goes from "from" to "to" as
 * time goes 0 to 1.
 *
 * @param from the "from" function
 *
 * @param to the "to" function
 */
public Scale(double from, double to)
{
	this(new Constant(from), new Constant(to));
}
/**
 * Construct a Scale that goes from "from" to "to" as
 * time goes 0 to 1.
 *
 * @param from the "from" function
 *
 * @param to the "to" function
 */
public Scale(Function f1, Function f2)
{
	this(new Constant(0), new T(), new Constant(1), f1, f2);
}
/**
 * Return "b" as a linear function that goes from bFrom
 * to bTo as "a" goes from aFrom to aTo.
 *
 * @param t the time function that goes 0 to 1 and that
 *          other functions use as a parameter
 *
 * @return "b" as a linear function that goes from bFrom
 *         to bTo as "a" goes from aFrom to aTo
 */
public double f(double t)
{
	double aFrom = source[0].f(t);
	double a = source[1].f(t);
	double aTo = source[2].f(t);
	double bFrom = source[3].f(t);
	double bTo = source[4].f(t);
	double denom = aTo - aFrom;
	if (denom == 0)
	{
		return (bTo + bFrom) / 2;
	}
	else
	{
		return (a - aFrom) / denom * (bTo - bFrom) + bFrom;
	}
}

/**
 * Construct a Scale that goes from "aFrom" to "aTo" as
 * function b goes from "bFrom" to "bTo". For example, Fahrenheit
 * goes 32 to 212 as Celsius goes 0 to 100.
 *
 * @param aFrom
 * @param a
 * @param aTo
 * @param bFrom
 * @param bTo 
 */
public Scale(
	Function aFrom,
	Function a,
	Function aTo,
	Function bFrom,
	Function bTo)
{
	super(new Function[] { aFrom, a, aTo, bFrom, bTo });
}
}