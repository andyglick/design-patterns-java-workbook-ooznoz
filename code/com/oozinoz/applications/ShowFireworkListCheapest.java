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
 * Show how a utility, specifically the Collections class
 * min() utility, can be added to the FireworkList class.
 * 
 * @author Steven J. Metsker
 */
public class ShowFireworkListCheapest 
{
/**
 * Show how a utility, specifically the Collections class
 * min() utility, can be added to the FireworkList class.
 */
public static void main(java.lang.String[] args)
{
	Firework cheap =
		Promo.getPromotionalFireworks().cheapest();
	System.out.println(
		"Our most budget-conscious promotional item: "
			+ cheap.getName());
}
}