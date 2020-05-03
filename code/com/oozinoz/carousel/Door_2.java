package com.oozinoz.carousel;

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
 * This refactoring of Door_1 moves state-specific logic
 * to a separate class hierarchy.
 * 
 * @author Steven J. Metsker
 */
public class Door_2 extends Observable 
{
	public final DoorState CLOSED = new DoorClosed(this);
	public final DoorState CLOSING =
		new DoorClosing(this);
	public final DoorState OPEN = new DoorOpen(this);
	public final DoorState OPENING =
		new DoorOpening(this);
	//
	private DoorState state = CLOSED;
	public final DoorState STAYOPEN =
		new DoorStayOpen(this);

/**
 * The carousel user has clicked the carousel button. This "one
 * touch" button elicits different behaviors, depending on the
 * state of the door.
 */
public void click()
{
	state.click();
}

/**
 * This is a notification from the mechanical carousel that the
 * door finished opening or shutting.
 */
public void complete()
{
	state.complete();
}

protected void setState(DoorState state)
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
	state.timeout();
}
}