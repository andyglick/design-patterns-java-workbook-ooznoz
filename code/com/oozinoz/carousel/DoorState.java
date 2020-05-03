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
 * This class is the top of a hierarchy of door state
 * classes.
 * 
 * @author Steven J. Metsker
 */
public abstract class DoorState 
{
	protected Door_2 door;

/**
 * Subclasses must decide what to do when the user
 * clicks the physical carousel button.
 */
public abstract void click();
/**
 * By default, discard notifications that the door
 * finished opening or closing.
 */
public void complete()
{
}
/**
 * Return a textual desciption of this state.
 *
 * @return a textual desciption of this state
 */
public String status()
{
	String s = getClass().getName();
	return s.substring(s.lastIndexOf('.') + 1);
}
/**
 * By default, discard notifications that the door
 * began closing after having been open for a while.
 */
public void timeout()
{
}

/**
 * Construct a state for the provided door.
 *
 * @param Door_2 a door that needs a state model
 */
public DoorState(Door_2 door)
{
	this.door = door;
}
}