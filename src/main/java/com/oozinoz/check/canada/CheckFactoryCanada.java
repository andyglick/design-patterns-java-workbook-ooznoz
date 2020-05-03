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
 * This factory supplies objects that can check credit, 
 * billing addresses, and shipping addresses in Canada.
 * 
 * @author Steven J. Metsker
 */
public class CheckFactoryCanada extends CheckFactory 
{
/**
 * Return a BillingCheck object for Canadian customers.
 *
 * @return a BillingCheck object for Canadian customers
 */
public BillingCheck createBillingCheck()
{
	return new BillingCheckCanada();
}
/**
 * Return a CreditCheck object for Canadian customers.
 *
 * @return a CreditCheck object for Canadian customers
 */
public CreditCheck createCreditCheck()
{
	if (isAgencyUp())
	{
		return new CreditCheckCanadaOnline();
	}
	else
	{
		return new CreditCheckOffline();
	}
}
/**
 * Return a ShippingCheck object for Canadian customers.
 *
 * @return a ShippingCheck object for Canadian customers
 */
public ShippingCheck createShippingCheck()
{
	return new ShippingCheckCanada();
}
}