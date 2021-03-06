package com.oozinoz.applications;

import com.oozinoz.machine.*;

import java.io.*;
import com.oozinoz.dublin.RakeVisitor;
import com.oozinoz.io.WrapFilter;

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
 * Show the use of the rake visitor that collects leaves.
 * 
 * @author Steven J. Metsker
 * @see com.oozinoz.dublin.RakeVisitor
 */
public class ShowRake 
{
/**
 * Show the use of the rake visitor that collects leaves.
 */
public static void main(String[] args)
throws IOException 
{
	MachineComponent f = OozinozFactory.dublin();
	Writer out = new PrintWriter(System.out);
	out = new WrapFilter(new BufferedWriter(out), 60);
	out.write(new RakeVisitor().getLeaves(f).toString());
	out.close();
}
}