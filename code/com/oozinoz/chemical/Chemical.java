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
 * This interface represents a chemical -- either an element 
 * or a molecule.
 *
 * @author Steven J. Metsker
 *
 */
public interface Chemical {
/**
 * Return the atomic weight of this chemical.
 *
 * @return  the atomic weight of this chemical
 *
 */
double getAtomicWeight();
/**
 * Return the number of moles that the provided amount of
 * the chemical will contain.
 *
 * @param grams a quantity of this chemical
 * @return the number of moles that the provided amount of
 *         the chemical will contain.
 *
 */
double getMoles(double grams);
/**
 * Return the name of this chemical.
 *
 * @return the name of this chemical
 *
 */
String getName();
/**
 * Return the convential symbol for this chemical.
 *
 * @return the convential symbol for this chemical (such
 *         as KNO3 for saltpetrer)
 *
 */
String getSymbol();
}