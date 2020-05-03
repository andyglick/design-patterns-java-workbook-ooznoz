package com.oozinoz.machine;

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
 * Represent a tool in an Oozinoz factory. Tools are like
 * machines but are less stationary. They roll around on
 * tool carts.
 *
 * @author Steven J. Metsker
 *
 */
public class Tool 
{
	protected ToolCart toolCart;


/**
 * Return the tool cart with which this tool is associated.
 *
 * @return the tool cart with which this tool is associated.
 */
public ToolCart getToolCart()
{
	return toolCart;
}

/**
 * Construct a tool associated with the provided tool cart.
 *
 */
public Tool(ToolCart toolCart)
{
	this.toolCart = toolCart;
}

/**
 * Return the engineer who is responsible for tools in
 * this tool's tool cart.
 *
 * @return the engineer who is responsible for tools in
 *         this tool's tool cart.
 */
public Engineer getResponsible()
{
	return toolCart.getResponsible();
}
}