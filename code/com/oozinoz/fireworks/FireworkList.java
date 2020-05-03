package com.oozinoz.fireworks;

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
 * Provide a type-specific collection, namely a list of
 * Firework objects.
 * 
 * @author Steven J. Metsker
 * @see com.oozinoz.applications.ShowFireworkList
 * @see com.oozinoz.applications.ShowFireworkListCheapest
 */
public class FireworkList 
{
	protected List list = new ArrayList();
	public class Itr {
		private Iterator iterator = list.iterator();
		public boolean hasNext()
	    {
			return iterator.hasNext();
		}
		public Firework next()
 	    {
			return (Firework) iterator.next();
		}
	}
/**
 * Appends the specified firework to the end of this list.
 *
 * @param Firework the object to add
 */
public void add(Firework f)
{
	list.add(f);
}
/**
 * Return the firework at the specified position in this list.
 *
 * @param index the index of the firework to return
 * @return the firework at the specified position in this list
 * @throws IndexOutOfBoundsException if the index is out of range
 */
public Firework get(int index)
{
	return (Firework) list.get(index);
}
/**
 * Return an iterator over the fireworks in this list.
 *
 * @return an iterator over the fireworks in this list
 */
public FireworkList.Itr iterator()
{
	return new Itr();
}
/**
 * Return the number of fireworks in this list. 
 *
 * @return the number of fireworks in this list
 */
public int size()
{
	return list.size();
}

/**
 * Return our most budget-conscious promotional firework.
 *
 * @return our most budget-conscious promotional firework.
 */
public Firework cheapest()
{
	Comparator c = new Comparator()
	{
			public int compare(Object o1, Object o2)
			{
				Firework f1 = (Firework) o1;
				Firework f2 = (Firework) o2;
				return (int) (100 * (f1.getPrice() - f2.getPrice()));
			}
	};
	return (Firework) Collections.min(list, c);
}
}