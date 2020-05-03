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
 * Instances of this class can check attributes of 
 * a shipping address in the U.S.
 */
public class ShippingCheckUS implements ShippingCheck 
{



/**
 * Return true if this shipping address incurs a tariff.
 *
 * @return true if this shipping address incurs a tariff
 */
public boolean hasTariff()
{
	return true;
}
}