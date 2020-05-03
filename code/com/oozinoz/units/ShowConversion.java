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
 * Show a few unit conversions.
 *
 * @author Steve Metsker
 */
public class ShowConversion implements UnitConstants 
{
/**
 * Show a few unit conversions.
 */
public static void main(String[] args)
{
	Volume v = (Volume) QUART.times(3);
	showVolume(v);
}
/**
 * Just here to show the conversion technique. 
 */
public static void showVolume(Volume v)
{
	System.out.println("I see: ");
	System.out.println(
		"\t" + v.divide(GALLON) + " gallon(s),");
	System.out.println(
		"\t" + v.divide(CUBIC_INCH) + " cubic inch(es),");
	System.out.println(
		"\t" + v.divide(MILLILITER) + " milliliter(s).");
}
}