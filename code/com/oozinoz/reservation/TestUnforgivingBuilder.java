package com.oozinoz.reservation;

import java.util.*;

/**
 * Test UnforgivingBuilder.
 *
 * @author Steve Metsker
 */
public class TestUnforgivingBuilder
extends junit.framework.TestCase 
{
/**
 * Create an instance with the given name. 
 *
 * @param name a name for these tests
 */
public TestUnforgivingBuilder(String name)
{
	super(name);
}
/**
 * Run the test- methods of this class.
 */
public static void main(String[] args)
{
	new junit.awtui.TestRunner().start(
		new String[] { "com.oozinoz.reservation.TestUnforgivingBuilder" });
}
/**
 * Test that we disallow a too low figure for dollars/head.
 */
public void testLowDollars()
{
	String sample =
		"Date, November 5, Headcount, 250, "
			+ "City, Springfield, DollarsPerHead, 1.95, "
			+ "HasSite, No";
	ReservationBuilder b = new UnforgivingBuilder();
	new ReservationParser(b).parse(sample);
	try
	{
		Reservation r = b.build();
	}
	catch (BuilderException e)
	{
		return;
	}
	fail("low dollars slipped through");
}
/**
 * Test that we disallow a too low figure for headcount.
 */
public void testLowHeadCount()
{
	String s =
		"Date, November 5, Headcount, 2, "
			+ "City, Springfield, DollarsPerHead, 9.95, "
			+ "HasSite, No";
	ReservationBuilder b = new UnforgivingBuilder();
	new ReservationParser(b).parse(s);
	try
	{
		Reservation r = b.build();
	}
	catch (BuilderException e)
	{
		return;
	}
	fail("low head count slipped through");
}
/**
 * Test that we disallow missing dollars.
 */
public void testNoDollars()
{
	String sample =
		"Date, November 5, Headcount, 250, "
			+ "City, Springfield, "
			+ "HasSite, No";
	ReservationBuilder b = new UnforgivingBuilder();
	new ReservationParser(b).parse(sample);
	try
	{
		Reservation r = b.build();
	}
	catch (BuilderException e)
	{
		return;
	}
	fail("no dollars slipped through");
}
/**
 * Test that we disallow missing headcount.
 */
public void testNoHeadCount()
{
	String s =
		"Date, November 5, "
			+ "City, Springfield, DollarsPerHead, 9.95, "
			+ "HasSite, No";
	ReservationBuilder b = new UnforgivingBuilder();
	new ReservationParser(b).parse(s);
	try
	{
		Reservation r = b.build();
	}
	catch (BuilderException e)
	{
		return;
	}
	fail("bad head count slipped through");
}
/**
 * Test a normal reservation.
 */
public void testNormal() throws BuilderException 
{
	String s =
		"Date, November 5, Headcount, 250, City, Springfield, "
			+ "DollarsPerHead, 9.95, HasSite, No";
	UnforgivingBuilder b = new UnforgivingBuilder();
	ReservationParser p = new ReservationParser(b);
	p.parse(s);
	Reservation r = b.build();
	//
	Calendar c = Calendar.getInstance();
	c.clear();
	c.set(2000, Calendar.NOVEMBER, 5);
	TestForgivingBuilder.futurize(c);
	//
	assertEquals(c.getTime(), r.date);
	assertEquals(250, r.headcount);
	assertEquals("Springfield", r.city);
	assertEquals(9.95, r.dollarsPerHead, .01);
	assertEquals(false, r.hasSite);
}
/**
 * Test that we disallow missing city.
 */
public void testUnforgivingNoCity()
{
	String s =
		"Date, November 5, Headcount, 250, "
			+ "DollarsPerHead, 9.95, "
			+ "HasSite, No";
	ReservationBuilder b = new UnforgivingBuilder();
	new ReservationParser(b).parse(s);
	try
	{
		Reservation r = b.build();
	}
	catch (BuilderException e)
	{
		return;
	}
	fail("bad city slipped through");
}
/**
 * Test that we disallow missing date.
 */
public void testUnforgivingNoDate()
{
	String s =
		"Headcount, 250, "
			+ "City, Springfield, DollarsPerHead, 9.95, "
			+ "HasSite, No";
	ReservationBuilder b = new UnforgivingBuilder();
	new ReservationParser(b).parse(s);
	try
	{
		Reservation r = b.build();
	}
	catch (BuilderException e)
	{
		return;
	}
	fail("bad date slipped through");
}
}