package com.oozinoz.reservation;

import java.util.Date;

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
 * Subclasses of this abstract class validate a reservation's
 * attributes before constructing a Reservation object.
 * 
 * @author Steven J. Metsker
 */
public abstract class ReservationBuilder
implements ReservationConstants 
{
	protected Date date;
	protected String city;
	protected int headcount;
	protected double dollarsPerHead;
	protected boolean hasSite;
/**
 * Construct a valid reservation from attributes that have
 * been presumably been set for this builder. Subclasses may
 * throw a runtime exception if a valid reservation cannot
 * be formed.
 
 * @return a valid reservation
 
 * @exception BuilderException if this method cannot build a
 *                             valid reservation
 */
public abstract Reservation build() throws BuilderException;
/**
 * Set the city for a reservation.
 *
 * @param String the city for a reservation
 */
public void setCity(String city)
{
	this.city = city;
}
/**
 * Set the date for a reservation.
 *
 * @param Date the date for a reservation
 */
public void setDate(Date date)
{
	this.date = date;
}
/**
 * Set the dollars/head that a customer will pay for a display.
 *
 * @param double the dollars/head that a customer will pay 
 *               for a display.
 */
public void setDollarsPerHead(double dollarsPerHead)
{
	this.dollarsPerHead = dollarsPerHead;
}
/**
 * Indicate whether a customer has a site in mind for a
 * display.
 *
 * @param boolean true, if the customer has a site in mind
 *                for a display
 */
public void setHasSite(boolean hasSite)
{
	this.hasSite = hasSite;
}
/**
 * Set the number of people that a customer will guarantee for 
 * a display.
 *
 * @param int the number of people that a customer will 
 *            guarantee for a display
 */
public void setHeadcount(int headcount)
{
	this.headcount = headcount;
}
}