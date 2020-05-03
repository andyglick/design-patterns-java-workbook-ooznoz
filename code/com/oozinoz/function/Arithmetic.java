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
 * Wrap an arithmetic function around a pair of given sources.
 * 
 * @author Steven J. Metsker
 */
public class Arithmetic extends Function 
{
	protected char operator;
/**
 * Construct an arithmetic function that decorates the 
 * provided source functions.
 *
 * @param char the operator to apply (+ - * /)
 *
 * @param Function the first source function that this
 *                 function wraps
 *
 * @param Function the second source function 
 */
public Arithmetic(
	char operator,
	Function f1,
	Function f2)
{
	super(new Function[] { f1, f2 });
	this.operator = operator;
}
/**
 * Return the result of applying this objects' arithmetic 
 * operator (+ - * /) to the source functions' values
 * at time t.
 *
 * @param t the time function that goes 0 to 1 and that
 *          other functions use as a parameter
 *
 * @return the result of applying this objects' arithmetic 
 *         operator (+ - * /) to the source functions' values
 *         at time t
 */
public double f(double t)
{
	switch (operator)
	{
		case '+' :
			return source[0].f(t) + source[1].f(t);
		case '-' :
			return source[0].f(t) - source[1].f(t);
		case '*' :
			return source[0].f(t) * source[1].f(t);
		case '/' :
			return source[0].f(t) / source[1].f(t);
		default :
			return 0;
	}
}
}