package com.oozinoz.aster;

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
 * This class is a placeholder for Aster star press hooks.
 * By default the star press class uses null hooks; clients
 * can substitute more interesting commands.
 * 
 * @author Steven J. Metsker
 */
public class NullHook implements Hook 
{
/**
 * Do nothing.
 */
public void execute(AsterStarPress2 asp)
{
}
}