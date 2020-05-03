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
 * This abstract class represents a hierarchy of classes
 * that encapsulate commands. A command object is a request
 * that is dormant until a caller asks it to execute.
 * <p>
 * Subclasses typically encapsulate some primary function, 
 * and allow for parameters that tailor a command to a 
 * purpose. All subclasses must implement an <code>execute
 * </code> command, which is abstract here.
 * 
 * @author Steven J. Metsker
 */
public abstract class Command 
{
/**
 * Perform the request encapsulated in this command.
 */
public abstract void execute(Context c);
}