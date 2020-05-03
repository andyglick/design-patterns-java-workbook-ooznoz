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
 * This interface defines the common behaviors for checking
 * a billing address.
 */
public interface BillingCheck {
/**
 * Return true if this billing address is residential.
 *
 * @return true if this billing address is residential
 */
boolean isResidential();
}