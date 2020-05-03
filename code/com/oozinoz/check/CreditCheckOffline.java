package com.oozinoz.check;

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
 * Objects of this class check credit using a series of
 * agent/customer dialogs.
 * 
 * @author Steven J. Metsker
 */
public class CreditCheckOffline implements CreditCheck 
{
/**
 * Return the acceptable credit limit for the person
 * with the supplied identification number.
 */
public double creditLimit(int id)
{
	// logic goes here to dialog with call center rep to
	// ascertain a reasonable credit limit
	return 0;
}
}