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
 * Objects of this class check credit by dialing out to
 * credit service bureaus.
 * 
 * @author Steven J. Metsker
 */
public class CreditCheckOnline implements CreditCheck 
{
/**
 * Return the acceptable credit limit for the person
 * with the supplied identification number.
 */
public double creditLimit(int id)
{
	// logic goes here to contact a credit agency
	return 0;
}
}