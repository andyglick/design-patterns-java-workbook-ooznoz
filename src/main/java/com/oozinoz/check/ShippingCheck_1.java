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
 * Instances of this class can check attributes of 
 * a shipping address. The underscore in this class's name
 * indicates that we will refactor this class. Specifically,
 * we will change "ShippingCheck" to be an interface that
 * different classes will implement for U.S. and Canadian
 * checks.
 */
public class ShippingCheck_1 
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