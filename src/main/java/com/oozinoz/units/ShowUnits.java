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
 * A measure is a combination of a quantity and a dimension.
 * For example, .75 square inches has a dimension of length
 * squared and a quantity that is usually internally derived.
 * For example,
 * <blockquote><pre>
 *     Area a = (Area) INCH.times(INCH).times(.75);
 * </pre></blockquote>
 * The INCH contstant is a measure defined in UnitConstants.
 *
 * @author Steve Metsker
 */
public class ShowUnits implements UnitConstants 
{
/**
 * Show the example in the class coment.
 */
public static void main(String[] args)
{
	Area a = (Area) INCH.times(INCH).times(.75);
}
}