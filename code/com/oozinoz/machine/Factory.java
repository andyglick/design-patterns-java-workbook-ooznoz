package com.oozinoz.machine;

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
 * This class is just here to look at lazy-initializing a
 * singleton.
 *
 * @author Steven J. Metsker
 *
 */
public class Factory 
{
	private static Factory factory;
private Factory()
{
}
/**
 * @return a Factory singleton
 */
public static Factory getFactory()
{
	if (factory == null)
	{
		factory = new Factory();
	}
	return factory;
}
}