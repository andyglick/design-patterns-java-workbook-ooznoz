package com.oozinoz.util;

import java.util.*;

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
 * Iterate over a component that has children.
 *
 * @author Steven J. Metsker
 *
 */
public class CompositeIterator
extends ComponentIterator 
{






	protected Iterator children;
	protected Object peek;
	protected ComponentIterator subiterator;

/**
 * Create an iterator over a component that has children
 *
 * @param node the node to iterate over
 * @param List the node's children
 * @param visited a set to track visited nodes
 */
public CompositeIterator(
	Object node,
	List components,
	Set visited)
{
	super(node, visited);
	children = components.iterator();
}

/**
 * Return the current depth of the iteration. Iterators walk
 * down a tree, so the depth of this iterator is the depth
 * of a subiterator plus one.
 *
 * @return the current depth of the iteration (that is, for
 *         the current node the number of nodes above it)
 */
public int depth()
{
	if (subiterator != null)
	{
		return subiterator.depth() + 1;
	}
	return 0;
}

/**
 * Return true if there is another node to see
 *
 * @return true if there is another node to see
 */
public boolean hasNext()
{
	if (peek == null)
	{
		peek = next();
	}
	return peek != null;
}

/**
 * Return the next node in the iteration
 *
 * @return the next node in the iteration
 */
public Object next()
{
	if (peek != null)
	{
		Object o = peek;
		peek = null;
		return o;
	}
	if (!visited.contains(node))
	{
		visited.add(node);
		if (showInterior)
		{
			return node;
		}
	}
	return nextDescendant();
}

/*
 * Usually just return the subiterator's next element. But
 * if the subiterator doesn't exist or doesn't have a
 * next element, create an iterator for the next child.
 * (If there is no next child, just return null.) Create
 * an iterator for this child and return this iterator's
 * next element. 
 */
protected Object nextDescendant()
{
	while (true)
	{
		if (subiterator != null)
		{
			if (subiterator.hasNext())
			{
				return subiterator.next();
			}
		}
		if (!children.hasNext())
		{
			return null;
		}
		Iterable i = (Iterable) children.next();
		if (!visited.contains(i))
		{
			subiterator = i.iterator(visited);
			subiterator.setShowInterior(showInterior);
		}
	}
}
}