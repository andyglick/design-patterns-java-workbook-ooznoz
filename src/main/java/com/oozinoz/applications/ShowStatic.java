package com.oozinoz.applications;

import com.oozinoz.units.*;
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
 * Show which static method Java calls when an object's
 * declared and actual types differ.
 * 
 * @author Steven J. Metsker 
 */
public class ShowStatic implements UnitConstants 
{
/**
 * Show which static method Java calls when an object's
 * declared and actual types differ.
 */
public static void main(String[] args)
{
	Length apogee = (Length) METER.times(75);
	Firework r = new Rocket("Byebaby", 13.95, apogee);
	System.out.println(r.flies());
}
}