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
 * In a set of parametric functions that parameterize on
 * time t, this is the identity function that always
 * returns the value of t.
 * 
 * @author Steven J. Metsker
 */
public class T extends Function {
/**
 * Constuct the identity function for t.
 */
public T() {
	super(new Function[0]);
}
/**
 * Return t, the current time in the function
 *
 * @param t the current time in the function
 * @return t
 */
public double f(double t)
{
	return t;
}
}