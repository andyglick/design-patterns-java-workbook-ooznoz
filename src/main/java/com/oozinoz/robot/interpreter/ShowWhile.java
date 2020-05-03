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
 * Show a "while" command.
 * 
 * @author Steven J. Metsker
 */
public class ShowWhile 
{
/**
 * Show a "while" command.
 */
public static void main(String[] args)
{
	Context c = MachineLine.createContext();
	Constant sp = new Constant(c.lookup("StarPress1401"));
	Constant ub = new Constant(c.lookup("UnloadBuffer1501"));
	WhileCommand wc =
		new WhileCommand(
			new HasMaterial(sp),
			new CarryCommand(sp, ub));
	wc.execute(c);
}
}