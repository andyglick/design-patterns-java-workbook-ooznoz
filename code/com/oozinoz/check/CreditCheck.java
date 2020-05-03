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
 * This interface defines the common behaviors for online
 * and offline credit check classes.
 */
public interface CreditCheck {
/**
 * Return the acceptable credit limit for the person
 * with the supplied identification number.
 */
double creditLimit(int id);
}