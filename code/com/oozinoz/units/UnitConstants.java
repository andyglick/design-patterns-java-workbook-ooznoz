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
 * This interface records constants that model common
 * physical units.
 *
 * For example, a class that implements this interface
 * can check the number of watts in 1 horsepower.
 * <blockquote><pre>
 *     Constant c = (Constant) HORSEPOWER.divide(WATT);
 *     assertEquals(746, c.magnitude(), .1);
 * </pre></blockquote>
 *
 * You might set the area of dud zone as follows:
 * <blockquote><pre>
 *     Length radius = (Length) METER.times(350);
 *     zone.setArea((Area) radius.times(radius).times(Math.PI));
 * </pre></blockquote>
 *
 * The conversion factors for units come from the "CRC 
 * Handbook of Chemistry and Physics."
 *
 * @author Steve Metsker
 */
public interface UnitConstants
	extends DimensionConstants {
	// kernel 
	Length M = new Length(1);
	Mass   K = new Mass(1);
	Time   S = new Time(1);
	// length
	Length METER = M;
	Length CM = (Length) M.times(.01);
	Length MILLIMETER = (Length) M.times(.001);
	Length MM = MILLIMETER;
	Length KILOMETER = (Length) M.times(1000);
	Length CENTIMETER = CM;
	Length INCH = (Length) CM.times(2.54);
	Length FOOT = (Length) INCH.times(12);
	Length FEET = FOOT;
	Length YARD = (Length) FOOT.times(3);
	Length MILE = (Length) FOOT.times(5280);
	// area
	Area ACRE = (Area) FOOT.times(FOOT).times(43560);
	Area HECTARE = (Area) M.times(M).times(10000);
	// volume
	Volume MILLILITER =
		(Volume) CM.times(CM).times(CM);
	Volume LITER = (Volume) MILLILITER.times(1000);
	Volume CUBIC_INCH =
		(Volume) INCH.times(INCH).times(INCH);
	Volume FLUID_OUNCE =
		(Volume) MILLILITER.times(29.572702);
	Volume PINT = (Volume) FLUID_OUNCE.times(16);
	Volume CUP = (Volume) PINT.times(.5);
	Volume TABLESPOON = (Volume) CUP.times(1. / 16.);
	Volume TEASPOON =
		(Volume) TABLESPOON.times(1. / 3.);
	Volume QUART = (Volume) PINT.times(2);
	Volume GALLON = (Volume) QUART.times(4);
	// mass
	Mass KG = K;
	Mass KILOGRAM = K;
	Mass GRAM = (Mass) K.times(.001);
	// time
	Time SECOND = S;
	Time MINUTE = (Time) S.times(60);
	Time HOUR = (Time) MINUTE.times(60);
	Time DAY = (Time) HOUR.times(24);
	Time WEEK = (Time) DAY.times(7);
	// physical constants
	Acceleration G =
		(Acceleration) M.times(9.807).divide(S).divide(S);
	Speed C = (Speed) M.times(299792458).divide(S);
	// force
	Force NEWTON =
		(Force) K.times(M).divide(S).divide(S);
	Force POUND = (Force) GRAM.times(G).times(453.59237);
	// pressure
	Pressure PASCAL =
		(Pressure) NEWTON.divide(M).divide(M);
	Pressure PSF =
		(Pressure) POUND.divide(FOOT).divide(FOOT);
	Pressure PSI =
		(Pressure) POUND.divide(INCH).divide(INCH);
	// energy
	Energy JOULE = (Energy) NEWTON.times(M);
	// power
	Power WATT = (Power) JOULE.divide(S);
	Power HORSEPOWER =
		(Power) FOOT.times(POUND).times(550).divide(S);
}