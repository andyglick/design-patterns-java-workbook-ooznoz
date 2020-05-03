package com.oozinoz.dubious;



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
 * Show the features of an OoString.
 * 
 * @author Steven J. Metsker
 */
public class ShowOoString 
{
/**
 * Show the features of an OoString.
 */
public static void main(String args[])
{
	OoString os =
		new OoString(
			"Launch our newest rocket "
				+ "from any international waters!");
	os.setRandomCase();
	os.setTitleCase();
	System.out.println(os);
}
}