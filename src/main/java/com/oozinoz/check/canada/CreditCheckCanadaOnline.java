package com.oozinoz.check.canada;

import com.oozinoz.check.*;

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
 * a (Canadian) credit service bureau.
 * 
 * @author Steven J. Metsker
 */
public class CreditCheckCanadaOnline
implements CreditCheck 
{

/**
 * Return the acceptable credit limit for the person
 * with the supplied identification number.
 */
public double creditLimit(int id)
{
	// logic goes here to contact a canadian credit agency
	return 0;
}
}