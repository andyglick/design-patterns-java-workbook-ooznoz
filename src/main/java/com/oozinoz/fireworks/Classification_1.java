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
 * Objects of this class represent classifications of 
 * fireworks. In the United States, fireworks are 
 * classified as either "consumer" fireworks, or as 
 * "display" fireworks. Only consumer fireworks can be 
 * purchased and used without a license. States vary 
 * considerably in their decisions regarding which types of 
 * fireworks are "consumer" fireworks.
 * <p>
 * The name of this class ends with an underscore in order to 
 * distinguish it from a later version of the class that 
 * also appears in "The Design Patterns Java Workbook." 
 * Normally when you refactor code you should not include 
 * versioning information in class names. You should use a 
 * configuration management system to keep track of 
 * different versions. However, multiple versions of the 
 * "Classification" class appear simultaneously in the book 
 * and the naming scheme helps keep to differentiate 
 * these versions.
 *
 * @author Steven J. Metsker
 */
public class Classification_1 {
	/**
	 * The classification for fireworks that may be purchased
	 * and used without a license.
	 */
	public static final Classification_1 CONSUMER =
		new Classification_1(); 
	/**
	 * The classification for fireworks that may be purchased
	 * and used only by a icensed operator.
	 */
	public static final Classification_1 DISPLAY =
		new Classification_1(); 
/**
 * The role of this class is to enumerate valid firework 
 * classifications. This class should not be instantiated
 * except for the static variables it creates itself, so
 * this method is private.
 */
private Classification_1()
{
}
}