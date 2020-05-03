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
 * Implement the Advisor interface, recommending a random
 * firework.
 * 
 * @author Steven J. Metsker
 */
public class RandomAdvisor implements Advisor 
{
	public static final RandomAdvisor singleton =
		new RandomAdvisor();
private RandomAdvisor()
{
}
/**
 * Just recommend a random firework.
 *
 * @param Customer ignored
 * @return a random firework
 */
public Firework recommend(Customer c)
{
	return Firework.getRandom();
}
}