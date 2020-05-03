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
 * Model the behavior of a carousel door when it's opening.
 * 
 * @author Steven J. Metsker
 */
public class DoorOpening extends DoorState 
{

/**
 * Stop opening and start closing the door.
 */
public void click()
{
	door.setState(door.CLOSING);
}
/**
 * Switch the state to OPEN.
 */
public void complete()
{
	door.setState(door.OPEN);
}

/**
 * Construct a state for the provided door.
 */
public DoorOpening(Door_2 door)
{
	super(door);
}
}