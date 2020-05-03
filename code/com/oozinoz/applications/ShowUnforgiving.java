package com.oozinoz.applications;

import com.oozinoz.reservation.*;

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
 * Show how to build a reservation from a textual request.
 * 
 * @author Steven J. Metsker 
 */
public class ShowUnforgiving 
{
/**
 * Show how to build a reservation from a textual request.
 */
public static void main(String[] args)
{
	String sample =
		"Date, November 5, Headcount, 250, "
			+ "City, Springfield, DollarsPerHead, 9.95, "
			+ "HasSite, No";
	ReservationBuilder b = new UnforgivingBuilder();
	new ReservationParser(b).parse(sample);
	try
	{
		Reservation r = b.build();
		System.out.println(r);
	}
	catch (BuilderException e)
	{
		System.out.println(e.getMessage());
	}
}
}