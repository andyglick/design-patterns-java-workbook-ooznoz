package com.oozinoz.applications;

import com.oozinoz.process.*;
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
 * Show the use of the PrettyVisitor class.
 * 
 * @author Steven J. Metsker
 * @see com.oozinoz.dublin.PrettyVisitor
 */
public class ShowPretty 
{
/**
 * Show the use of the PrettyVisitor class.
 */
public static void main(String[] args)
{
	ProcessComponent p = ShellProcess.make();
	PrettyVisitor v = new PrettyVisitor();
	System.out.println(v.getPretty(p));
}
}