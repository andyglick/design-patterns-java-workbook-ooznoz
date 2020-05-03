package com.oozinoz.robot.interpreter;

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
 * This class does nothing when it executes.
 * 
 * @author Steven J. Metsker
 */
public class NullCommand extends Command 
{
/**
 * Do nothing.
 */
public void execute(Context c)
{
}
}