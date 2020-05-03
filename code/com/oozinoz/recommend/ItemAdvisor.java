package com.oozinoz.recommend;

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
 * Implement the Advisor interface by relying on the LikeMyStuff
 * engine that models a customer's preferences on his or her
 * eariler purchases.
 * 
 * @author Steven J. Metsker
 */
public class ItemAdvisor implements Advisor 
{
	public static final ItemAdvisor singleton =
		new ItemAdvisor();
private ItemAdvisor()
{
}
/**
 * Recommend a nice item for this customer, based on a model
 * of the customer's recent spending with us.
 *
 * @param Customer the customer to cross-sell
 * @return a nice item for the customer to buy
 */
public Firework recommend(Customer c)
{
	return (Firework) LikeMyStuff.suggest(c);
}
}