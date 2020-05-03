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
 * Iterate over a leaf, returning it just once.
 *
 * @author Steven J. Metsker
 *
 */
public class LeafIterator extends ComponentIterator 
{





/**
 * Create an iterator over a childless node in a composite.
 *
 * @param node the childless node
 * @param visited a set to track visited nodes
 */
public LeafIterator(Object node, Set visited)
{
	super(node, visited);
}

/**
 * Return zero, as the depth of iterators below a leaf is
 * always zero.
 *
 * @return zero, as the depth of iterators below a leaf is
 *         always zero
 */
public int depth()
{
	return 0;
}

/**
 * Return true if we haven't actually returned our node
 * yet.
 *
 * @return true if we haven't actually returned our 
 *         node yet.
 */
public boolean hasNext()
{
	return !visited.contains(node);
}

/**
 * Return this node if we haven't returned it previously;
 * otherwise return null.
 *
 * @return this node if we haven't returned it previously;
 *         otherwise return null.
 */
public Object next()
{
	if (visited.contains(node))
	{
		return null;
	}
	visited.add(node);
	return node;
}
}