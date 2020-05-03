package com.oozinoz.carousel_sol;

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
 * Model the behavior of a carousel door when it's closed. This
 * refactoring uses constant state values.
 * 
 * @author Steven J. Metsker
 */
public class DoorClosed extends DoorState 
{
/**
 * Open the door.
 */
public void click(Door door)
{
	door.setState(OPENING);
}
}