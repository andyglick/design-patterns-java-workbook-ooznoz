package com.oozinoz.fireworks;

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
 * Objects of this class represent types of fireworks.
 * This class is a precursor to the Firework class that 
 * looks for classification constants in an interface 
 * instead of a class.
 * 
 * @author Steven J. Metsker
 */
public class Firework_1 
{
	protected String name;
	protected Classification_1 classification;
/**
 * Construct a firework with the given name. 
 *
 * @param String the name of the firework
 */
public Firework_1(String name)
{
	this(name, Classification_1.DISPLAY);
}










/**
 * Construct a firework with the given name and classification.
 *
 * @param String the name of the firework
 *
 * @param Classification_ the classification of the 
 *                        firework
 */
public Firework_1(
	String name,
	Classification_1 classification)
{
	this.name = name;
	this.classification = classification;
}

/**
 * Returns this firework's classification.
 *
 * @return this firework's classification
 */
public Classification_1 getClassification()
{
	return classification;
}

/**
 * Set this firework's classification.
 *
 * @param Classification this firework's classification
 */
public void setClassification(Classification_1 classification)
{
	this.classification = classification;
}
}