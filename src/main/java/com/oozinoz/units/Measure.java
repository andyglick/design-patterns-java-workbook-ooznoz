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
 * A measure is a combination of a magnitude and a dimension.
 * For example, .75 square inches has a dimension of length
 * squared and a quantity that is usually internally derived.
 * For example,
 * <blockquote><pre>
 *     Area a = (Area) INCH.times(INCH).times(.75);
 * </pre></blockquote>
 * The INCH constant is a measure defined in UnitConstants.
 *
 * @author Steve Metsker
 */
public class Measure implements DimensionConstants 
{
	protected double magnitude;
	protected Dimension dimension;
/**
 * Create a measure with the given magnitude and dimension.
 * The usual way to create a dimension is from existing
 * units, not by using this constructor. For example,
 *
 * <blockquote><pre>
 *     Length radius = (Length) METER.times(350);
 * </pre></blockquote>
 *
 * @param magnitude the size of this measure in an mks system
 * @param dimension the dimensoin of this measure
 */
public Measure(double magnitude, Dimension dimension)
{
	this.magnitude = magnitude;
	this.dimension = dimension;
}
/**
 * Return the measure that results from dividing this measure
 * from the one supplied.
 *
 * @param Measure the measure to divide by
 * @return a measure that results from dividing this measure
 *         from the one supplied.
 */
public Measure divide(Measure m)
{
	return measure(
		magnitude / m.magnitude,
		dimension.divide(m.dimension));
}

/**
 * Create a measure that, if possible, is an appropriate
 * subtype of the Measure hierarchy, such as an Area.
 *
 * @param magnitude the size of this measure in an mks system
 * @param dimension the dimensoin of this measure
 * @return a measure that, if possible, is an appropriate
 *         subtype of the Measure hierarchy
 */
public static Measure measure(
	double magnitude,
	Dimension d)
{
	if (d.equals(CONSTANT))
	{
		return new Constant(magnitude);
	}
	if (d.equals(LENGTH))
	{
		return new Length(magnitude);
	}
	if (d.equals(AREA))
	{
		return new Area(magnitude);
	}
	if (d.equals(VOLUME))
	{
		return new Volume(magnitude);
	}
	if (d.equals(MASS))
	{
		return new Mass(magnitude);
	}
	if (d.equals(TIME))
	{
		return new Time(magnitude);
	}
	if (d.equals(SPEED))
	{
		return new Speed(magnitude);
	}
	if (d.equals(ACCELERATION))
	{
		return new Acceleration(magnitude);
	}
	if (d.equals(FORCE))
	{
		return new Force(magnitude);
	}
	if (d.equals(PRESSURE))
	{
		return new Pressure(magnitude);
	}
	if (d.equals(ENERGY))
	{
		return new Energy(magnitude);
	}
	if (d.equals(POWER))
	{
		return new Power(magnitude);
	}
	if (d.equals(DENSITY))
	{
		return new Density(magnitude);
	}
	// default
	return new Measure(magnitude, d);
}
/**
 * Return the measure that results from adding this measure
 * to the one supplied.
 *
 * @param Measure the measure to add
 * @return a measure that results from adding this measure
 *         to the one supplied.
 */
public Measure plus(Measure m) throws MeasureException 
{
	if (!(dimension.equals(m.dimension)))
	{
		throw new MeasureException(
			"Cannot add " + this +" and " + m);
	}
	return new Measure(magnitude + m.magnitude, dimension);
}
/**
 * Round a number to the indicated number of significant
 * digits.
 *
 * @param number the number to round
 * @param nDigit the number of significant digits
 * @return a rounded number
 */
public static double round(double x, int nDigit)
{
	double exponent = Math.log(x) / Math.log(10);
	int magnitude = (int) Math.floor(exponent);
	int divisorExponent = magnitude - (nDigit - 1);
	int divisor = 1;
	for (int i = 0; i < Math.abs(divisorExponent); i++)
	{
		divisor *= 10;
	}
	if (divisorExponent > 0)
	{
		return Math.round(x / divisor) * divisor;
	}
	else
	{
		return Math.round(x * divisor) / (double) divisor;
	}
	/* 
	
	How this works.
	
	Let's say I have 1234.5678 and I want 2 significant digits 
	(that is, 1200.0). The strategy is to find the "right" 
	power of 10 to work with. In this example, the right number 
	is 100. To complete the rounding, divide by 100, round 
	using Math.round(), and multiply by 100. The trick is to 
	find the power of 10 to work with.
	
	The starting number, written in exponential notation is 
	1.2345678 * 10**3. We want log base 10 of this number to 
	get a grip on its size.
	
	There is no log base 10 function, but suppose
	
		y = log 10 (x)
	
	Then
	
		10 ** y = x
		Ln(10 ** y) = Ln(x) // Ln is a function I do have
		y * Ln(10) = Ln(x)
		y = Ln(x)/Ln(10) // this is a formula for y
		
	The "magnitude," for lack of a better term, is floor(y), in 
	the example case 3.
	
	I said I want 2 significant digits; in the example I would 
	divide by 100; in general the divisor is:
	
		10**(magnitude - (nDigit - 1))
		
	In this case the exponent is:
	
		3 - (2 - 1), or 2
	
	The code calculates 10**divisorExponent manually because Math.pow()
	was creating problems, specifically with negative exponents. For
	example, Math.pow(10, -1) is not exactly .1.	
		
	The rest of the algorithm is: divide by the divisor, round, 
	and multiply by the divisor.
	*/
}
/**
 * Return the measure that results from multiplying this 
 * measure's magnitude by the supplied value.
 *
 * @param double the number to multiply the magnitude by
 * @return a measure that results from multiplying this 
 *         measure's magnitude by the number supplied.
 */
public Measure times(double d)
{
	return measure(magnitude * d, dimension);
}
/**
 * Return the measure that results from multiplying this 
 * measure by the one supplied.
 *
 * @param Measure the measure to multiply by
 * @return a measure that results from multiplying this 
 *         measure by the one supplied.
 */
public Measure times(Measure m)
{
	return measure(
		magnitude * m.magnitude,
		dimension.times(m.dimension));
}
/**
 * Return a textual representation of this measure.
 *
 * @return a textual representation of this measure
 */
public String toString()
{
	double mag = round(magnitude, 4);
	if (dimension.equals(CONSTANT))
	{
		return "" + mag;
	}
	if (dimension.equals(LENGTH))
	{
		return "" + mag + " meters";
	}
	if (dimension.equals(AREA))
	{
		return "" + mag + " meters**2";
	}
	if (dimension.equals(VOLUME))
	{
		return "" + mag + " meters**3";
	}
	if (dimension.equals(MASS))
	{
		return "" + mag + " kilograms";
	}
	if (dimension.equals(TIME))
	{
		return "" + mag + " seconds";
	}
	if (dimension.equals(SPEED))
	{
		return "" + mag + " meters/second";
	}
	if (dimension.equals(ACCELERATION))
	{
		return "" + mag + " meters/second**2";
	}
	if (dimension.equals(FORCE))
	{
		return "" + mag + " newtons";
	}
	if (dimension.equals(ENERGY))
	{
		return "" + mag + " joules";
	}
	if (dimension.equals(POWER))
	{
		return "" + mag + " watts";
	}
	if (dimension.equals(DENSITY))
	{
		return "" + mag + " kilograms/meter**3";
	}
	return "" + mag + dimension;
}

/**
 * Show this measure as a quantity of another, given measure.
 * For example,
 *
 * <blockquote><pre>
 *     System.out.println(FOOT.as(INCH) + " inches");
 * </pre></blockquote>
 * displays:
 * <blockquote><pre>
 *     12.0 inches
 * </pre></blockquote>
 *
 * Note that this method is identical to divide().
 *
 * @param Measure the measure to divide by
 * @return a measure that results from dividing this measure
 *         from the one supplied.
 */
public Measure as(Measure m)
{
	return divide(m);
}

/**
 * Return true if this object is equal to the supplied one,
 * within the specified tolerance for the magnitudes.
 *
 * @return true if this object is equal to the supplied one,
 * within the specified tolerance for the magnitudes
 */
public boolean equals(Measure m, double tolerance)
{
	if (dimension != m.getDimension())
	{
		return false;
	}
	return Math.abs(getMagnitude() - m.getMagnitude())
		<= tolerance;
}

/**
 * Return the dimension of this measure.
 *
 * @return the dimension of this measure
 */
public Dimension getDimension()
{
	return dimension;
}

/**
 * Return the magnitude of this measure.
 *
 * @return the magnitude of this measure. Note that measures
 *         are stored internally in an MKS (meter/kilogram/
 *         second) system.
 */
public double getMagnitude()
{
	return magnitude;
}

/**
 * Return a measure that results from subtracting the
 * supplied measure from this one.
 *
 * @param Measure the measure to subtract
 * @return a measure that results from subtracting the
 *         supplied measure from this one
 */
public Measure minus(Measure m) throws MeasureException 
{
	if (!(dimension.equals(m.dimension)))
	{
		throw new MeasureException(
			"Cannot subtract " + m + " from " + this);
	}
	return new Measure(magnitude - m.magnitude, dimension);
}
}