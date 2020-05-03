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
 * Objects of this class represent reservations for fireworks
 * displays, but note that this class in not fully developed.
 * The classes in this package show how to use builders to
 * validate an object's state before constructing it. This
 * class is just a target for the builders in this package.
 * 
 * @author Steven J. Metsker
 */
public class Reservation 
{
	protected Date date;
	protected int headcount; 
	protected String city;
	protected double dollarsPerHead;
	protected boolean hasSite;
	


/**
 * Construct a reservation with the given parameters. The
 * proper way to construct a reservation is with one of the
 * builders in this package, so this method is <code>protected
 * </code>.
 *
 * @param   Date   when to put on a display
 * @param   Headcount   how many people our customer will
 *                      guarantee to be in attendance
 * @param   City   the city (or nearest city) for the display
 * @param   DollarsPerHead   the price per attendee the
 *                           customer will pay
 * @param   HasSite   true, if the customer has a display site
 *                    in mind
 */
protected Reservation(
	Date date,
	int headcount,
	String city,
	double dollarsPerHead,
	boolean hasSite)
{
	this(
		date,
		headcount,
		city,
		dollarsPerHead,
		hasSite,
		false);
}
/**
 * Returns a textual description of this reservation.
 *
 * @return a textual description of this reservation
 */
public String toString()
{
	StringBuffer buf = new StringBuffer();
	buf.append("Date: ");
	DateFormat f =
		DateFormat.getDateInstance(DateFormat.MEDIUM);
	buf.append(f.format(date));
	buf.append(", Headcount: ");
	buf.append(headcount);
	buf.append(", City: ");
	buf.append(city);
	buf.append(", Dollars/Head: ");
	buf.append(dollarsPerHead);
	buf.append(", Has Site: ");
	buf.append(hasSite);
	return buf.toString();
}

	protected boolean counteroffer;

/**
 * Construct a reservation with the given parameters. The
 * proper way to construct a reservation is with one of the
 * builders in this package, so this method is <code>protected
 * </code>.
 *
 * @param   Date   when to put on a display
 * @param   Headcount   how many people our customer will
 *                      guarantee to be in attendance
 * @param   City   the city (or nearest city) for the display
 * @param   DollarsPerHead   the price per attendee the
 *                           customer will pay
 * @param   HasSite   true, if the customer has a display site
 *                    in mind
 * @param   counteroffer   true, if the reservation is
 *                         modification of a request
 */
protected Reservation(
	Date date,
	int headcount,
	String city,
	double dollarsPerHead,
	boolean hasSite,
	boolean counteroffer)
{
	this.date = date;
	this.headcount = headcount;
	this.city = city;
	this.dollarsPerHead = dollarsPerHead;
	this.hasSite = hasSite;
	this.counteroffer = counteroffer;
}

/**
 * Indicate that a reservation is a counteroffer that goes
 * beyond a user's request.
 */
public void setCounteroffer(boolean counteroffer)
{
	this.counteroffer = counteroffer;
}
}