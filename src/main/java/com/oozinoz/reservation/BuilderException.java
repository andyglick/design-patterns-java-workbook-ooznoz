package com.oozinoz.reservation;

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
 * Signals a problem while building a reservation from its
 * attributes.
 * 
 * @author Steven J. Metsker
 */
public class BuilderException extends Exception 
{
/**
 * Constructs a <code>BuilderException</code> with no detail 
 * message.
 */
public BuilderException()
{
	super();
}

/**
 * Constructs a <code>BuilderException</code> with the 
 * specified detail message. 
 *
 * @param String the detail message.
 */
public BuilderException(String s)
{
	super(s);
}
}