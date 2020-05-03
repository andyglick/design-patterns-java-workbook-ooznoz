package com.oozinoz.carousel;

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
 * Model the behavior of a carousel door when it's closing.
 * 
 * @author Steven J. Metsker
 */
public class DoorClosing extends DoorState 
{

/**
 * Stop closing and start opening the door.
 */
public void click()
{
	door.setState(door.OPENING);
}
/**
 * Switch the state to CLOSED.
 */
public void complete()
{
	door.setState(door.CLOSED);
}

/**
 * Construct a state for the provided door.
 */
public DoorClosing(Door_2 door)
{
	super(door);
}
}