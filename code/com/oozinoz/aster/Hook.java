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
 * This interface defines hook commands that may be
 * inserted at various places in Aster's star press
 * processing code.
 * 
 * @author Steven J. Metsker
 */
public interface Hook {
/**
 * Execute a command on the given star press.
 */
void execute(AsterStarPress2 asp);
}