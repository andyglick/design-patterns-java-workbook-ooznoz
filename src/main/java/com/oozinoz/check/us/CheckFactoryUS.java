package com.oozinoz.check.us;

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
 * billing addresses, and shipping addresses in the U.S.
 * 
 * @author Steven J. Metsker
 */
public class CheckFactoryUS extends CheckFactory 
{
/**
 * Return a BillingCheck object for US customers.
 *
 * @return a BillingCheck object for US customers
 */
public BillingCheck createBillingCheck()
{
	return new BillingCheckUS();
}
/**
 * Return a CreditCheck object for US customers.
 *
 * @return a CreditCheck object for US customers
 */
public CreditCheck createCreditCheck()
{
	if (isAgencyUp())
	{
		return new CreditCheckUSOnline();
	}
	else
	{
		return new CreditCheckOffline();
	}
}
/**
 * Return a ShippingCheck object for US customers.
 *
 * @return a ShippingCheck object for US customers
 */
public ShippingCheck createShippingCheck()
{
	return new ShippingCheckUS();
}
}