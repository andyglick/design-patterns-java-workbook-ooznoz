package com.oozinoz.carousel_sol;

/**
 * Define the states for a carousel door.
 */
public interface DoorConstants {
	DoorState CLOSED = new DoorClosed();
	DoorState OPENING = new DoorOpening();
	DoorState OPEN = new DoorOpen();
	DoorState CLOSING = new DoorClosing();
	DoorState STAYOPEN = new DoorStayOpen();
}