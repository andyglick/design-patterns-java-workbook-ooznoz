package com.oozinoz.aster.client;

import com.oozinoz.aster.*;

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
 * This class tunes the behavior of a (fictional) Aster
 * star press.
 * 
 * @author Steven J. Metsker
 */
public class OzAsterStarPress extends AsterStarPress 
{
/**
 * Override the superclass to have our robot collect the
 * discharged paste before the star presses flushes
 * itself with water.
 */
public void dischargePaste()
{
	super.dischargePaste();
	getFactory().collectPaste(this);
}
/**
 * Get the material manager singleton.
 *
 * @return the material manager singleton
 */
public MaterialManager getManager()
{
	return MaterialManager.getManager();
}
/**
 * Let the Oozinoz material manager know that his
 * mold is only partly processed.
 */
public void markMoldIncomplete(int id)
{
	getManager().setMoldIncomplete(id);
}

/**
 * Get the factory singleton.
 *
 * @return the factory singleton; not actually implemented
 */
public Factory getFactory()
{
	return null;
}
}