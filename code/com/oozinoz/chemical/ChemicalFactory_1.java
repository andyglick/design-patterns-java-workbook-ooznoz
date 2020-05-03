package com.oozinoz.chemical;

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
 * This class creates and returns Chemical_1 objects. We will
 * refactor this class to make Chemical an interface.
 *
 * @author Steven J. Metsker
 *
 */
public class ChemicalFactory_1 
{
	private static Map chemicals = new HashMap();
	static 
	{
		chemicals.put(
			"carbon",
			new Chemical_1("Carbon", "C", 12));
		chemicals.put(
			"sulfur",
			new Chemical_1("Sulfur", "S", 32));
		chemicals.put(
			"saltpeter",
			new Chemical_1("Saltpeter", "KN03", 101));
		//...
	}




/**
 * Return the Chemical object for the given name.
 *
 * @param name the name of the interesting chemical
 * @return the Chemical object for the given name
 */
public static Chemical_1 getChemical(String name)
{
	return (Chemical_1) chemicals.get(name.toLowerCase());
}
}