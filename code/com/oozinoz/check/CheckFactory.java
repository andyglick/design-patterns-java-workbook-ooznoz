package com.oozinoz.check;

import com.oozinoz.check.us.CheckFactoryUS;
import com.oozinoz.check.canada.CheckFactoryCanada;

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
 * This factory supplies objects that can check credit, 
 * billing addresses, and shipping addresses.
 * 
 * @author Steven J. Metsker
 */
public abstract class CheckFactory 
{
	public static final CheckFactory US =
		new CheckFactoryUS();
	public static final CheckFactory CANADA =
		new CheckFactoryCanada(); 

/**
 * Return a BillingCheck object.
 *
 * @return an appropriate BillingCheck object, depending
 *         on where the customer resides
 */
public abstract BillingCheck createBillingCheck();
/**
 * Return a CreditCheck object.
 *
 * @return a CreditCheck object; the actual class of the
 *         object depends on whether the credit agency is up
 *         and which country the customer resides in.
 */
public abstract CreditCheck createCreditCheck();
/**
 * Return a ShippingCheck object.
 *
 * @return an appropriate ShippingCheck object, depending
 *         on the country of the shipping address
 */
public abstract ShippingCheck createShippingCheck();

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