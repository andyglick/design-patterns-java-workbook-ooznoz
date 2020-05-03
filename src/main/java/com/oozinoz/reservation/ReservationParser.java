package com.oozinoz.reservation;

import java.util.*;
import java.text.*;

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
 * This class parses a request for a fireworks exhibition.
 * The request must be a comma-separated list of parameter
 * names and values. The expected parameters for an
 * exhibition are: date, heacount, city, dollarsPerHead,
 * and hasSite. For example, a valid request is:
 *
 * <blockquote><pre>
 *     Date, November 5, Headcount, 250, City, Springfield,
 *	   DollarsPerHead, 9.95, HasSite, No
 * </pre></blockquote>
 *
 * The format for dates is the name of the month followed by
 * the day. This parser assumes the year for the date is the
 * year in which the date next occurs.
 * 
 * @author Steven J. Metsker 
 */
public class ReservationParser 
{
	protected ReservationBuilder builder;

/**
 * Parse a reservation request, passing its information to
 * the builder.
 *
 * @param String the request
 */
public void parse(String s)
{
	StringTokenizer st = new StringTokenizer(s, ",");
	while (st.hasMoreElements())
	{
		String type = st.nextToken().trim();
		if (st.hasMoreElements())
		{
			String value = st.nextToken().trim();
			parse(type, value);
		}
	}
}
/*
 * Handle a (type, value) pair
 */
protected void parse(String type, String value)
{
	if (type.equalsIgnoreCase("Date"))
	{
		parseDate(value);
	}
	if (type.equalsIgnoreCase("Headcount"))
	{
		builder.setHeadcount(Integer.parseInt(value));
	}
	if (type.equalsIgnoreCase("City"))
	{
		builder.setCity(value);
	}
	if (type.equalsIgnoreCase("DollarsPerHead"))
	{
		builder.setDollarsPerHead(Double.parseDouble(value));
	}
	if (type.equalsIgnoreCase("HasSite"))
	{
		if (value.equalsIgnoreCase("true")
			|| value.equalsIgnoreCase("yes"))
		{
			builder.setHasSite(true);
		}
		else
		{
			builder.setHasSite(false);
		}
	}
}
/*
 * Parse a date, using a SimpleDateFormat object that looks
 * for dates like "Nov 5" (with no year). Roll the year forward
 * until the date is in the future.
 */
protected void parseDate(String s)
{
	try
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(s));
		Calendar now = Calendar.getInstance();
		while (cal.before(now))
		{
			cal.add(Calendar.YEAR, 1);
		}
		builder.setDate(cal.getTime());
	}
	catch (ParseException e)
	{
		// let the builder deal with not getting a date
	}
}

/**
 * Create a parser that will pass its results to the specified
 * builder.
 *
 * @param ReservationBuilder the builder to pass parameters to
 */
public ReservationParser(ReservationBuilder builder) 
{
	this.builder = builder;
}
}