package com.oozinoz.chemical;

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
 * This class represents a type of chemical. The underscore
 * in the class name indicates that this class is ripe for
 * refactoring. We will refactor this into an interface that
 * an inner class of ChemicalFactory will implement.
 *
 * @author Steven J. Metsker
 *
 */
public class Chemical_1 
{
	public String name;
	public String symbol;
	public double atomicWeight;
/**
 * Insert the method's description here.
 * Creation date: (2/10/2001 7:06:42 AM)
 */
Chemical_1(
	String name,
	String symbol,
	double atomicWeight)
{
	//
	this.name = name;
	this.symbol = symbol;
	this.atomicWeight = atomicWeight;
}
/**
 * Insert the method's description here.
 * Creation date: (2/10/2001 7:01:08 AM)
 * @return double
 */
public double moles(double grams)
{
	return grams / atomicWeight;
}
/**
 * Insert the method's description here.
 * Creation date: (2/10/2001 2:43:12 PM)
 * @return java.lang.String
 */
public String toString()
{
	return name + "(" + symbol + ")[" + atomicWeight + "]";
}
}