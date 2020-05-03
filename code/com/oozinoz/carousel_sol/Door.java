package com.oozinoz.carousel_sol;

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
 * This class provides an initial models a carousel door
 * and uses constants for its states.
 * 
 * @author Steven J. Metsker
 */
public class Door
extends Observable implements DoorConstants 
{
	private DoorState state = CLOSED;

/**
 * The carousel user has clicked the carousel button. This "one
 * touch" button elicits different behaviors, depending on the
 * state of the door.
 */
public void click()
{
	state.click(this);
}

/**
 * This is a notification from the mechanical carousel that the
 * door finished opening or shutting.
 */
public void complete()
{
	state.complete(this);
}

public void setState(DoorState state)
{
	this.state = state;
	setChanged();
	notifyObservers();
}

/**
 * Return a textual description of the door's state.
 *
 * @return a textual description of the door's state
 */
public String status()
{
	return state.status();
}

/**
 * This is a notification from the mechanical carousel that the
 * door got tired of being open.
 */
public void timeout()
{
	state.timeout(this);
}
}