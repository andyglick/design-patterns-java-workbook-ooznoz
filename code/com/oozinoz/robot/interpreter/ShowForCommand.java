package com.oozinoz.robot.interpreter;


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
 * Show a "for" command.
 * 
 * @author Steven J. Metsker
 */
public class ShowForCommand 
{
/**
 * Show a "for" command.
 */
public static void main(String[] args)
{
	Context c = MachineLine.createContext();
	Variable m = new Variable("m");
	ForMachines fm =
		new ForMachines(m, new ShutdownCommand(m));
	fm.execute(c);
}
}