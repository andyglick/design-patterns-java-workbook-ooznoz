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
 */
public class Factory_2 
{
	private static Factory_2 factory;
private Factory_2()
{
	wipMoves = 0;
}


	private static final Object classLock = Factory_2.class;
	private long wipMoves;

/**
 * @return a Factory singleton
 */
public static Factory_2 getFactory()
{
	synchronized (classLock)
	{
		if (factory == null)
		{
			factory = new Factory_2();
		}
		return factory;
	}
}

/**
 * Register the fact that bin moved onto a new machine in
 * the factory.
 */
public void recordWipMove()
{
	synchronized (classLock)
	{
		wipMoves++;
	}
}
}