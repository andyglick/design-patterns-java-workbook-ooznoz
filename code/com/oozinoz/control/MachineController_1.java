package com.oozinoz.control;

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
 * This class is the top of a hierarchy of controllers. It
 * is an abstraction that depends on its subclasses for
 * implementations of its abstract operations. As such it
 * is ripe for refactoring to a bridge, moving the abstract
 * operations out into an interface.
 *
 * @author Steven J. Metsker
 *
 */
public abstract class MachineController_1 
{
/**
 * Return true if there is no more room in the input queue.
 *
 * @return true if there is no more room in the input queue
 */
public boolean inputFull()
{
	return getQueueMax() >= getQueue().size();
}

	protected Queue queue = new Queue();

/**
 * Return the queue of bins waiting for this machine.
 *
 * @return the queue of bins waiting for this machine
 */
public Queue getQueue()
{
	return queue;
}

/**
 * Return the maximum size of this machine's input queue.
 *
 * @return the maximum size of this machine's input queue
 */
public abstract int getQueueMax();

/**
 * Start this machine.
 */
public abstract void start();

/**
 * Stop this machine.
 */
public abstract void stop();
}