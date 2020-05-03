package com.oozinoz.util;

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
 * Define a type of object that can produce an iterator.
 *
 * @author Steven J. Metsker
 *
 */
public interface Iterable {
/**
 * Return some type of component iterator.
 *
 * @param visited a set of nodes that have already been
 *                iterated over
 */
public abstract ComponentIterator iterator(
	java.util.Set visited);
}