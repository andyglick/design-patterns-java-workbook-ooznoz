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
 * Model the behavior of a carousel door when it's open. This
 * refactoring uses constant state values.
 * 
 * @author Steven J. Metsker
 */
public class DoorOpen extends DoorState 
{
/**
 * Stay open until another click comes along.
 */
public void click(Door door)
{
	door.setState(STAYOPEN);
}
/**
 * Insert the method's description here.
 * Creation date: (5/15/01 12:30:54 PM)
 * @param args java.lang.String[]
 */
public void timeout(Door door) {
	door.setState(DoorConstants.CLOSING);
}
}