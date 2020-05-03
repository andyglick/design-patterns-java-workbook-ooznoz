package com.oozinoz.robot.interpreter;

import com.oozinoz.machine.Machine;

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
 * Show a "carry" command.
 * 
 * @author Steven J. Metsker
 */
public class ShowCarry 
{
/**
 * Show a "carry" command.
 */
public static void main(String[] args)
{
	Context c = MachineLine.createContext();
	Variable x = new Variable("x");
	Machine ub = c.lookup("UnloadBuffer1501");
	CarryCommand comm = new CarryCommand(x, new Constant(ub));
	c.assign(x, c.lookup("Mixer1201"));
	comm.execute(c);
	c.assign(x, c.lookup("StarPress1401"));
	comm.execute(c);
}
}