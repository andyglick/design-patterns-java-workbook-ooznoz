package com.oozinoz.applications;

import com.oozinoz.machine.Engineer;

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
 * 
 * This interface represents part of a user interface for a 
 * simulation that the "Chain of Responsibility" chapter in "The 
 * Design Patterns Java Workbook" discusses.
 * 
 * @author Steven J. Metsker
 */
public interface SimulatedItem {

/**
 * Return the engineer who is responsible for the machine
 * that this simulated item represents.
 *
 * @return the engineer who is responsible for the machine
 *         that this simulated item represents.
 */
Engineer getResponsible();
}