package com.oozinoz.remote;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

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
 * This class demonstrates how to implement an RMI interface.
 * 
 * @author Steven J. Metsker
 */
public class RocketImpl
extends UnicastRemoteObject
implements Rocket 
{
	protected double price;
	protected double apogee;
/**
 * Construct a rocket with the given price and apogee.
 */
public RocketImpl(double price, double apogee)
throws RemoteException 
{
	this.price = price;
	this.apogee = apogee;
}
/**
 * Set a factor to adjust a particular rocket's apogee.
 *
 * @param factor the factor
 */
public void boost(double factor)
{
	apogee *= factor;
}
/**
 * Return the expected height this rocket will reach.
 *
 * @return the expected height this rocket will reach
 */
public double getApogee() throws RemoteException 
{
	return apogee;
}
/**
 * Return the price of this rocket.
 *
 * @return the price of this rocket
 */
public double getPrice() throws RemoteException 
{
	return price;
}
}