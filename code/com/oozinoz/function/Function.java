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
 * This abstract superclass defines the role of a function
 * that wraps itself around (or "decorates") another function.
 * 
 * @author Steven J. Metsker
 */
public abstract class Function 
{
	protected Function[] source;

/**
 * Construct a function that decorates the provided source
 * functions.
 *
 * @param Function[] the source functions that this function
 *                   wraps
 */
public Function(Function[] source)
{
	this.source = source;
}
/**
 * Construct a function that decorates the provided source
 * function.
 *
 * @param Function the source function that this function
 *                 wraps
 */
public Function(Function f)
{
	this(new Function[] { f });
}

/**
 * Return true if these functions are of the same class
 * and their source functions are equal.
 *
 * @return true if these functions are of the same class
 *         and their source functions are equal
 */
public boolean equals(Object o)
{
	if (!getClass().equals(o.getClass()))
	{
		return false;
	}
	Function f = (Function) o;
	for (int i = 0; i < source.length; i++)
	{
		if (!source[i].equals(f.source[i]))
		{
			return false;
		}
	}
	return true;
}

/**
 * Apply this object's represented function to the source
 * function(s) at the given time and return the result.
 *
 * @param t the time function that goes 0 to 1 and that
 *          other functions use as a parameter
 *
 * @return the result of applying this object's represented
 *         function to the source function(s) at time t
 */
public abstract double f(double t);

/**
 * Return a textual representation of this function.
 *
 * @return a textual representation of this function
 */
public String toString()
{
	String name = getClass().getName();
	String name2 = name.substring(name.lastIndexOf('.') + 1);
	StringBuffer buf = new StringBuffer(name2);
	if (source.length > 0)
	{
		buf.append('(');
		for (int i = 0; i < source.length; i++)
		{
			if (i > 0)
			{
				buf.append(", ");
			}
			buf.append(source[i]);
		}
		buf.append(')');
	}
	return buf.toString();
}
}