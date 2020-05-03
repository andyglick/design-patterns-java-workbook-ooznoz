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
 * Model the behavior of a carousel door when it's closed.
 * 
 * @author Steven J. Metsker
 */
public class DoorClosed extends DoorState 
{

/**
 * Open the door.
 */
public void click()
{
	door.setState(door.OPENING);
}

/**
 * Construct a state for the provided door.
 */
public DoorClosed(Door_2 door)
{
	super(door);
}
}