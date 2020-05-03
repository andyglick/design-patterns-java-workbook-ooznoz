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
 * This factory produces objects that can check credit. This
 * class is a precursor to CheckFactory that provides a
 * family of verification objects.
 * 
 * @author Steven J. Metsker
 */
public abstract class CreditCheckFactory 
{
/**
 * Return a CreditCheck object.
 *
 * @return a CreditCheck object; the actual class of the
 *         object depends on whether the credit agency is up.
 */
public static CreditCheck createCreditCheck()
{
	if (isAgencyUp())
	{
		return new CreditCheckOnline();
	}
	else
	{
		return new CreditCheckOffline();
	}
}

/**
 * Return true if the service bureau is accessible.
 *
 * @return true if the service bureau is accessible. This
 *         method is not yet actually implemented.
 */
public static boolean isAgencyUp()
{
	return true;
}
}