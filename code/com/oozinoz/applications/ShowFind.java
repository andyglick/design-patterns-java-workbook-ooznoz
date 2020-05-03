package com.oozinoz.applications;

import com.oozinoz.machine.*;

import com.oozinoz.dublin.*;

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
 * Show the use of the FindVisitor class.
 * 
 * @author Steven J. Metsker
 * @see com.oozinoz.dublin.FindVisitor
 */
public class ShowFind 
{
/**
 * Show the use of the FindVisitor class.
 */
public static void main(String[] args)
{
	MachineComponent f = OozinozFactory.dublin();
	System.out.println(new FindVisitor().find(f, 3404));
}
}