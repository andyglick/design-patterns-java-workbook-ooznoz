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
 * This class creates and returns Chemical objects.
 *
 * @author Steven J. Metsker
 *
 */
public class ChemicalFactory 
{
	private static Map chemicals = new HashMap();
	static 
	{
		chemicals.put(
			"carbon",
			new ChemicalImpl("Carbon", "C", 12));
		chemicals.put(
			"sulfur",
			new ChemicalImpl("Sulfur", "S", 32));
		chemicals.put(
			"saltpeter",
			new ChemicalImpl("Saltpeter", "KN03", 101));
		//...
	}
	private static class ChemicalImpl implements Chemical 
	{
		private String name;
		private String symbol;
		private double atomicWeight;

		private ChemicalImpl(
			String name,
			String symbol,
			double atomicWeight)
		{
			this.name = name;
			this.symbol = symbol;
			this.atomicWeight = atomicWeight;
		}
		public String toString()
		{
			return name + "(" + symbol + ")";
		}
		public double getMoles(double grams)
		{
			return grams / atomicWeight;
		}
		public String getName()
		{
			return name;
		}
		public String getSymbol()
		{
			return symbol;
		}
		public double getAtomicWeight()
		{
			return atomicWeight;
		}
	}
/**
 * Return the Chemical object for the given name.
 *
 * @param name the name of the interesting chemical
 * @return the Chemical object for the given name
 */
public static Chemical getChemical(String name)
{
	return (Chemical) chemicals.get(name.toLowerCase());
}
}