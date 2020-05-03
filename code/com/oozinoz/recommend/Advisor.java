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
 * Defines a standard service for recommending a purchasable
 * item to a customer.
 * 
 * @author Steven J. Metsker
 */
public interface Advisor {
/**
 * Recommend a nice firework for this customer to purchase.
 *
 * @param Customer the prospective purchaser
 * @return a nice firework for this customer to purchase
 */
public Firework recommend(Customer c);
}