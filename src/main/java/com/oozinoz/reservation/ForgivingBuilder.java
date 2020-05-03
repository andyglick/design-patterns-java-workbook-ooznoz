package com.oozinoz.reservation;

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
 * This class builds a valid reservation from its attributes,
 * and fills in values where it can if the attributes are not
 * set. This builder must receive a city and a date, but it
 * will set reasonable values for the other reservation values.
 * 
 * @author Steven J. Metsker
 */
public class ForgivingBuilder extends ReservationBuilder 
{
public Reservation build() throws BuilderException 
{
	boolean noHeadcount = (headcount == 0);
	boolean noDollarsPerHead = (dollarsPerHead == 0.0);
	boolean counteroffer = noHeadcount || noDollarsPerHead;
	//
	if (noHeadcount && noDollarsPerHead)
	{
		headcount = MINHEAD;
		dollarsPerHead = MINTOTAL / headcount;
	}
	else if (noHeadcount)
	{
		headcount = (int) Math.ceil(MINTOTAL / dollarsPerHead);
		headcount = Math.max(headcount, MINHEAD);
	}
	else if (noDollarsPerHead)
	{
		dollarsPerHead = MINTOTAL / headcount;
	}
	//
	check();
	return new Reservation(
		date,
		headcount,
		city,
		dollarsPerHead,
		hasSite,
		counteroffer);
}

protected void check() throws BuilderException 
{
	if (date == null)
	{
		throw new BuilderException("Valid date not found");
	}
	if (city == null)
	{
		throw new BuilderException("Valid city not found");
	}
	if (headcount < MINHEAD)
	{
		throw new BuilderException(
			"Minimum headcount is " + MINHEAD);
	}
	if (dollarsPerHead * headcount < MINTOTAL)
	{
		throw new BuilderException(
			"Minimum total cost is " + MINTOTAL);
	}
}
}