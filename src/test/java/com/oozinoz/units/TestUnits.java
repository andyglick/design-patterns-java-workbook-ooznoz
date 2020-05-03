package com.oozinoz.units;

import junit.framework.*;

/**
 * Test classes in the com.oozinoz.units package.
 *
 * @author Steve Metsker
 */
public class TestUnits
extends TestCase
implements UnitConstants 
{
/**
 * Create an instance of TestUnits with the given name. There
 * are just a few tests here, but they give pretty good coverage
 * since things like power depend on length, time, and mass.
 *
 * @param name  a name for these tests
 */
public TestUnits(String name)
{
	super(name);
}
/**
 * Run the test- methods of this class.
 */
public static void main(String[] args)
{
	new junit.awtui.TestRunner().start(
		new String[] { "com.oozinoz.units.TestUnits" });
}
/*
 * Just here to check that type-checking works.
 */
private void setArea(Area a)
{
}
/**
 * Test acceleration units.
 */
public void testAcceleration()
{
	Acceleration a =
		(Acceleration) FEET.times(32.17).divide(SECOND).divide(
			SECOND);
	assertEquals(G.getDimension(), a.getDimension());
	assertEquals(G.getMagnitude(), a.getMagnitude(), .01);
}
/**
 * Test area units.
 */
public void testArea()
{
	Constant c = (Constant) MILE.times(MILE).divide(ACRE);
	assertEquals(640, c.magnitude, .1);
}
/**
 * Test code in comments in this package.
 */
public void testComments()
{
	// UnitConstants
	Length radius = (Length) METER.times(350);
	setArea((Area) radius.times(radius).times(Math.PI));
	// Measure
	Area a = (Area) INCH.times(INCH).times(.75);
}
/**
 * Test some conversions.
 */
public void testConversion()
{
	Measure m;
	m = (Area) INCH.times(INCH);
	m = (Area) GALLON.divide(FOOT);
	m = (Energy) POUND.times(METER);
}
/**
 * Test how many feet are in a mile.
 */
public void testFeetInAMile()
{
	Constant c = (Constant) MILE.divide(FOOT);
	assertEquals(5280, c.magnitude, .1);
}
/**
 * Test power units.
 */
public void testPower()
{
	Constant c = (Constant) HORSEPOWER.divide(WATT);
	assertEquals(745.7, c.getMagnitude(), .1);
}
/**
 * Test the Measure.round() function.
 */
public void testRound()
{
	assertEquals(1200, Measure.round(1234.5678, 2), .01);
	assertEquals(1234.57, Measure.round(1234.5678, 6), .01);
	assertEquals(1234.5678, Measure.round(1234.5678, 8), .01);
	assertEquals(
		.00033,
		Measure.round(.000333333, 2),
		.000001);
	assertEquals(1234, Measure.round(1234.001, 4), .000001);
}
/**
 * Test volume units.
 */
public void testVolume()
{
	Volume CUBIC_INCH = (Volume) INCH.times(INCH).times(INCH);
	Constant c;
	c = (Constant) GALLON.divide(CUBIC_INCH);
	assertEquals(231, c.magnitude, .1);
	c = (Constant) LITER.divide(CUBIC_INCH);
	assertEquals(61, c.magnitude, .1);
}
/**
 * Test weight units.
 */
public void testWeight()
{
	Force myWeight = (Force) POUND.times(180);
	double tolerance = .5;
	// note that to model a kilogram on Earth you must
	// accelerate it in accordance with the Earth's gravity
	assertTrue(
		myWeight.equals(
			KILOGRAM.times(G).times(81.6),
			tolerance));
}
}