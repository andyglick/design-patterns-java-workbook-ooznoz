package com.oozinoz.applications;

import com.oozinoz.fireworks.*;

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
 * Show an application of the FireworkList class.
 * 
 * @author Steven J. Metsker
 */
public class ShowFireworkList 
{
/**
 * Show an application of the FireworkList class.
 */
public static void main(String[] args)
{
	FireworkList flist = Promo.getPromotionalFireworks();
	FireworkList.Itr i = flist.iterator();
	while (i.hasNext())
	{
		Firework f = i.next();
		System.out.println(
			f.getName() + ", $" + f.getPrice() + ", " + f.getType());
	}
}
}