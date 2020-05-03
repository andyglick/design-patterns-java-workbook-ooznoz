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
 * This class represents a batch of chemicals. The underscore
 * in this class's name indicates that the class is ripe
 * for refactoring. We'll refactor this so that the immutable
 * aspect of a substance will move to a separate class.
 *
 * @author Steven J. Metsker
 *
 */
public class Substance_1 
{
	protected double grams;
	protected String name;
	protected String symbol;
	protected double atomicWeight;



/**
 * Return the number of moles in this substance. 
 *
 * @return the number of moles in this substance. See 
 *         the glossary in "The Design Patterns Java 
 *         Workbook" for a definition of "mole."
 */
public double getMoles()
{
	return grams / atomicWeight;
}
}