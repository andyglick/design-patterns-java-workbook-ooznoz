package com.oozinoz.machine;

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
 * A queue adds a little value to a list, supporting the
 * notions (and vocabulary) of enqueueing and dequeueing.
 *
 * @author Steven J. Metsker
 *
 */
public class Queue 
{
	protected List list;
/**
 * Create a empty queue.
 */
public Queue()
{
	this(new ArrayList());
}
/**
 * Create a queue that will operate on the supplied list.
 *
 * @param List the list to operate on
 */
public Queue(List list)
{
	this.list = list;
}
/**
 * Remove and return the head of the list.
 *
 * @return the head of the list
 */
public Object dequeue()
{
	return list.remove(0);
}
/**
 * Add the supplied object to the end of the list
 *
 * @param Object the thing to add to the end of the list
 */
public void enqueue(Object o)
{
	list.add(o);
}
/**
 * Return true if the list is empty
 *
 * @return true if the list is empty
 */
public boolean isEmpty()
{
	return list.isEmpty();
}

/**
 * Return the size of the queue.
 *
 * @return the size of the queue
 */
public int size()
{
	return list.size();
}
}