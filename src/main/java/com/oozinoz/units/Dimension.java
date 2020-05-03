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
 * A dimension object actually tracks the three dimensions of
 * typical physical quantities, namely length, mass, and time.
 *
 * A volume, for example, has a dimension of (3, 0, 0); it is
 * three-dimensional in length and has no mass or time.
 *
 * An acceleration has a dimension of (1, 0, -2), that is,
 * length per time per time.
 *
 * Dimensional arithmetic works with the exponents of 
 * dimensions. For example, length times length produces
 * a length dimension of 2.
 *
 * @author Steve Metsker
 */
public class Dimension 
{
	protected int lengthDim;
	protected int massDim;
	protected int timeDim;
/**
 * Create a new dimension object with the given extensions
 * of length, mass, and time.
 *
 * @param lengthDim the length dimension (1 represents length,
 *                  2 represents area, 3 represents volume)
 * @param massDim the mass dimension (usually 0 or 1)
 * @param timeDim the time dimension (usually between 1 
 *                and -2)
 */
public Dimension(int lengthDim, int massDim, int timeDim)
{
	this.lengthDim = lengthDim;
	this.massDim = massDim;
	this.timeDim = timeDim;
}
/**
 * Create a new dimension by dividing this one by another. For
 * example, speed is length (1, 0, 0) divided by time
 * (0, 0, 1), resulting in (1, 0, -1). Dimensional arithmetic
 * adds or subtracts the dimensions (or exponents) of length,
 * mass, and time.
 *
 * @return a new dimension
 */
public Dimension divide(Dimension d)
{
	return new Dimension(
		lengthDim - d.lengthDim,
		massDim - d.massDim,
		timeDim - d.timeDim);
}
/**
 * Return true if these dimensions share the same extension
 * in length, mass, and time.
 *
 * @return true, if these dimensions share the same extension
 * in length, mass, and time.
 */
public boolean equals(Object o)
{
	if (!(o instanceof Dimension))
	{
		return false;
	}
	Dimension d = (Dimension) o;
	return lengthDim == d.lengthDim
		&& massDim == d.massDim
		&& timeDim == d.timeDim;
}
/**
 * Create a new dimension by multiplying this one by another.
 *
 * @return a new dimension
 */
public Dimension times(Dimension d)
{
	return new Dimension(
		lengthDim + d.lengthDim,
		massDim + d.massDim,
		timeDim + d.timeDim);
}
/**
 * Return a textual representation of this dimension.
 *
 * @return a textual representation of this dimension.
 */
public String toString()
{
	StringBuffer buf = new StringBuffer();
	buf.append('(');
	buf.append(lengthDim);
	buf.append(',');
	buf.append(massDim);
	buf.append(',');
	buf.append(timeDim);
	buf.append(')');
	return buf.toString();
}

/**
 * Return a code that is suitable for indexing this dimension.
 *
 * @return a code that is suitable for indexing this dimension.
 */
public int hashCode()
{
	return 100 * lengthDim + 10 * massDim + timeDim;
}
}