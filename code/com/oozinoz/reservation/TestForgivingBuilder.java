package com.oozinoz.reservation;

import java.util.*;

/**
 * Test ForgivingBuilder.
 *
 * @author Steve Metsker
 */
public class TestForgivingBuilder
extends junit.framework.TestCase 
{
/**
 * Create an instance with the given name. 
 *
 * @param name a name for these tests
 */
public TestForgivingBuilder(String name)
{
	super(name);
}
/**
 * Push a date into the future by rolling forward the year.
 */
public static void futurize(Calendar c)
{
	Calendar now = Calendar.getInstance();
	while (c.before(now))
	{
		c.add(Calendar.YEAR, 1);
	}
}
/**
 * Run the test- methods of this class.
 */
public static void main(String[] args)
{
	new junit.awtui.TestRunner().start(
		new String[] { "com.oozinoz.reservation.TestForgivingBuilder" });
}
/**
 * Test that we disallow a too low figure for dollars/head.
 */
public void testLowDollars()
{
	String s =
		"Date, November 5, Headcount, 250, "
			+ "City, Springfield, DollarsPerHead, 1.95, "
			+ "HasSite, No";
	ReservationBuilder b = new ForgivingBuilder();
	new ReservationParser(b).parse(s);
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
	ReservationBuilder b = new ForgivingBuilder();
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
 * Test that we disallow a missing city.
 */
public void testNoCity()
{
	String s =
		"Date, November 5, Headcount, 250, "
			+ "DollarsPerHead, 9.95, "
			+ "HasSite, No";
	ReservationBuilder b = new ForgivingBuilder();
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
 * Test that we disallow a missing date.
 */
public void testNoDate()
{
	String s =
		"Headcount, 250, "
			+ "City, Springfield, DollarsPerHead, 9.95, "
			+ "HasSite, No";
	ReservationBuilder b = new ForgivingBuilder();
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
/**
 * Test that if there is a headcount but no dollars/head value, set the 
 * dollars/head value to be high enough to generate the minimum take.
 */
public void testNoDollar() throws BuilderException 
{
	String s =
		"Date, November 5, Headcount, 250, City, Springfield, "
			+ "  HasSite, No";
	ForgivingBuilder b = new ForgivingBuilder();
	ReservationParser p = new ReservationParser(b);
	p.parse(s);
	Reservation r = b.build();
	//
	Calendar c = Calendar.getInstance();
	c.clear();
	c.set(2000, Calendar.NOVEMBER, 5);
	futurize(c);
	//
	assertEquals(c.getTime(), r.date);
	assertEquals(250, r.headcount);
	assertTrue(r.headcount * r.dollarsPerHead >= ReservationConstants.MINTOTAL);
	assertEquals("Springfield", r.city);
	assertEquals(false, r.hasSite);
}
/**
 * Test that if there is no headcount but there is a dollars/head value, 
 * set the headcount to be at least the minimum attendance and at least 
 * enough to generate enough money for the event. 
 */
public void testNoHeadcount() throws BuilderException 
{
	String s =
		"Date, November 5,   City, Springfield, "
			+ "DollarsPerHead, 9.95, HasSite, No";
	ForgivingBuilder b = new ForgivingBuilder();
	ReservationParser p = new ReservationParser(b);
	p.parse(s);
	Reservation r = b.build();
	//
	Calendar c = Calendar.getInstance();
	c.clear();
	c.set(2000, Calendar.NOVEMBER, 5);
	futurize(c);
	//
	assertEquals(c.getTime(), r.date);
	assertTrue(r.headcount >= ReservationConstants.MINHEAD);
	assertTrue(r.headcount * r.dollarsPerHead >= ReservationConstants.MINTOTAL);
	assertEquals("Springfield", r.city);
	assertEquals(9.95, r.dollarsPerHead, .01);
	assertEquals(false, r.hasSite);
}
/**
 * Test that if the reservation request specifies no headcount and no 
 * dollars/head, set the headcount to the minimum and set dollars/head 
 * to the minimum total divided by the headcount. 
 */
public void testNoHeadcountNoDollar() throws BuilderException 
{
	String s =
		"Date, November 5,   City, Springfield, "
			+ "  HasSite, No";
	ForgivingBuilder b = new ForgivingBuilder();
	ReservationParser p = new ReservationParser(b);
	p.parse(s);
	Reservation r = b.build();
	//
	Calendar c = Calendar.getInstance();
	c.clear();
	c.set(2000, Calendar.NOVEMBER, 5);
	futurize(c);
	//
	assertEquals(c.getTime(), r.date);
	assertEquals(ReservationConstants.MINHEAD, r.headcount);
	assertEquals("Springfield", r.city);
	assertEquals(ReservationConstants.MINTOTAL/r.headcount, r.dollarsPerHead, .01);
	assertEquals(false, r.hasSite);
}
/**
 * Test a normal reservation.
 */
public void testNormal() throws BuilderException 
{
	String s =
		"Date, November 5, Headcount, 250, City, Springfield, "
			+ "DollarsPerHead, 9.95, HasSite, No";
	ForgivingBuilder b = new ForgivingBuilder();
	ReservationParser p = new ReservationParser(b);
	p.parse(s);
	Reservation r = b.build();
	//
	Calendar c = Calendar.getInstance();
	c.clear();
	c.set(2000, Calendar.NOVEMBER, 5);
	futurize(c);
	//
	assertEquals(c.getTime(), r.date);
	assertEquals(250, r.headcount);
	assertEquals("Springfield", r.city);
	assertEquals(9.95, r.dollarsPerHead, .01);
	assertEquals(false, r.hasSite);
}
}