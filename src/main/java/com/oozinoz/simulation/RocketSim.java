package com.oozinoz.simulation;
import com.oozinoz.units.*;

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
 * This interface brings out a few subtleties regarding
 * Java interfaces. See "Introducing Interfaces" in "The
 * Design Patterns Java Workbook."
 *
 * @author Steve Metsker
 */
public interface RocketSim {
	/** 
	 * Return the projected height this rocket will achieve.
	 *
	 * @return the projected height this rocket will achieve
	 */
	abstract Length apogee();
	/** 
	 * Return the projected thrust this rocket will produce
	 *
	 * @return the projected thrust this rocket will produce
	 */
	public Force thrust();
}