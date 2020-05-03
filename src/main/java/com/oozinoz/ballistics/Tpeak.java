package com.oozinoz.ballistics;

import java.util.*;

/*
 * Copyright (c) 2000 Steven J. Metsker. All Rights Reserved.
 * 
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose, 
 * including the implied warranty of merchantability.
 */

/**
 * Instances of this class provide an observably changeable
 * model of the time at which a fuel's burn area peaks.
 * 
 * @author Steven J. Metsker
 *
 * @version 1.0
 */
public class Tpeak extends Observable 
{
	protected double value;
/**
 * Create a model of the time at which a fuel's burn area
 * peaks.
 * 
 * @param value the initial peak time
 */
public Tpeak(double value) 
{
	this.value = value;
}
/**
 * Return the current value of the peak time.
 *
 * @return the current value of the peak time
 */
public double getValue() 
{
	return value;
}
/**
 * Set the current value of the peak time and notify
 * observers.
 *
 * @param value the current value of the peak time
 */
public void setValue(double value) 
{
	this.value = value;
	setChanged();
	notifyObservers();
}
}