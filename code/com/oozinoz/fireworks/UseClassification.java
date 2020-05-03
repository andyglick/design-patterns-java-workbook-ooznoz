package com.oozinoz.fireworks;

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
 * Show a bit of code that uses the Classification
 * class and the ClassificationConstants interface.
 *
 * @author Steven J. Metsker
 */
public class UseClassification
implements ClassificationConstants 
{
/**
 * Just showing how to the Classification class constants.
 */
public void secureOrder(Firework f /*, etc. */)
{
	//...
	if (f.classification == DISPLAY)
	{
		// issue warning
	}
	else
	{
		// proceed
	}
}
}