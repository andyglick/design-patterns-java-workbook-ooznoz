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
 * Show an "if" command.
 * 
 * @author Steven J. Metsker
 */
public class ShowIf 
{
/**
 * Show an "if" command.
 */
public static void main(String[] args)
{
	Context c = MachineLine.createContext();
	Variable m = new Variable("m");
	Constant ub = new Constant(c.lookup("UnloadBuffer1501"));
	Term t = new Equals(m, ub);
	IfCommand ic =
		new IfCommand(
			t,
			new NullCommand(),
			new ShutdownCommand(m));
	ForMachines fc = new ForMachines(m, ic);
	fc.execute(c);
}
}