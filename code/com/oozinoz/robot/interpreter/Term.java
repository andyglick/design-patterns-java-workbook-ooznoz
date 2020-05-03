package com.oozinoz.robot.interpreter;

import com.oozinoz.machine.*;

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
 * A term is usually either a machine or a variable that
 * refers to a machine. Some terms, though, are boolean
 * expressions with eval() methods that return null to
 * indicate false.
 * 
 * @author Steven J. Metsker
 */
public abstract class Term 
{
/**
 * Evaluate this term in the given context. For example,
 * a variable term will look up its name in the context
 * and return a machine.
 *
 * @param Context a mapping of names to machines
 */
public abstract Machine eval(Context c);
}