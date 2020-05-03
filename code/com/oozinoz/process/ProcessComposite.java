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
 * Represent either an alternation or a sequence of
 * process steps.
 *
 * @author Steven J. Metsker
 *
 */
public abstract class ProcessComposite
extends ProcessComponent
{
	protected List subprocesses;
/**
 * Create a process composite with the given name.
 *
 * @param name this process composite's name 
 */
public ProcessComposite(String name)
{
	this(name, new ArrayList());
}
/**
 * Create a composite with the given name and containing the
 * given subprocesses.
 *
 * @param name the identity of this composite
 * @param subprocesses the children of this composite
 */
public ProcessComposite(
	String name,
	ProcessComponent[] subprocesses)
{
	this(name, Arrays.asList(subprocesses));
}
/**
 * Create a composite with the given name and containing the
 * given subprocesses.
 *
 * @param name the identity of this composite
 * @param subprocesses the children of this composite
 */
public ProcessComposite(String name, List subprocesses)
{
	super(name);
	this.subprocesses = subprocesses;
}
/**
 * Add the given component as a child.
 *
 * @param component the component to add
 */
public void add(ProcessComponent c)
{
	subprocesses.add(c);
}


/**
 * Return the number of steps (leaf nodes) in the tree
 * that this composite represents
 * 
 * @param visited components already visited while traversing
 *                this component
 * @return the number of steps (leaf nodes) in the 
 *         tree that this composite represents
 */
public int getStepCount(Set visited)
{
	visited.add(this);
	int count = 0;
	Iterator i = subprocesses.iterator();
	while (i.hasNext())
	{
		ProcessComponent pc = (ProcessComponent) i.next();
		if (!visited.contains(pc))
		{
			count += pc.getStepCount(visited);
		}
	}
	return count;
}

/**
 * Return this composite's children.
 *
 * @return this composite's children
 */
public List getSubprocesses()
{
	return subprocesses;
}

/**
 * Return an iterator for this composite.
 *
 * @return an iterator for this composite
 */
public ComponentIterator iterator(Set visited)
{
	return new CompositeIterator(this, subprocesses, visited);
}
}