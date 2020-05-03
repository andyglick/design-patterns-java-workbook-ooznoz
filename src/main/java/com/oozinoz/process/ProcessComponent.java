package com.oozinoz.process;

import java.util.*;

import com.oozinoz.util.*;

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
 * Objects of this class represent either individual
 * process steps or compositions of process steps. A process
 * is essentially a recipe for manufacturing something,
 * notably fireworks.
 *
 * @author Steven J. Metsker
 *
 */
public abstract class ProcessComponent
implements com.oozinoz.util.Iterable 
{
	protected String name;
/**
 * Create a process component with the given name.
 *
 * @param name this process component's name 
 */
public ProcessComponent(String name)
{
	this.name = name;
}


/**
 * Return a textual representation of this component.
 *
 * @return a textual representation of this component
 */
public String toString()
{
	return name;
}

/**
 * Accepts a "visitor" along with a collection of previously
 * visited processes.
 *
 * @param   ProcessVisitor   the visitor to accept
 *
 * @param   Vector   a collection of previously visited 
 *                   parsers.
 */
public abstract void accept(ProcessVisitor v);

/**
 * Return this component's name.
 * 
 * @return this component's name
 */
public String getName()
{
	return name;
}

/**
 * Return the number of leaf node steps in this
 * composite.
 * 
 * @return the number of leaf node steps in this
 *         composite.
 */
public int getStepCount()
{
	return getStepCount(new HashSet());
}

/**
 * Return the number of leaf node steps in this
 * composite.
 *
 * @param visited components already visited while traversing
 *                this component
 * @return the number of leaf node steps in this
 *         composite.
 */
public abstract int getStepCount(Set visited);

/**
 * Return an iterator for this component.
 *
 * @return an iterator for this component
 */
public ComponentIterator iterator()
{
	return iterator(new HashSet());
}

/**
 * Return some type of component iterator.
 *
 * @param visited a set of nodes that have already been
 *                iterated over
 */
public abstract ComponentIterator iterator(Set s);
}