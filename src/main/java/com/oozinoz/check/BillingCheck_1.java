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
 * a billing address. The underscore in this class's name
 * indicates that we will refactor this class. Specifically,
 * we will change "BillingCheck" to be an interface that
 * different classes will implement for U.S. and Canadian
 * checks.
 */
public class BillingCheck_1 
{
/**
 * Return true if this billing address is residential.
 *
 * @return true if this billing address is residential
 */
public boolean isResidential()
{
	return true;
}
}