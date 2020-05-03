package com.oozinoz.robot.interpreter;

import com.oozinoz.machine.*;

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
 * Carry a bin from one machine to another, allowing for
 * machines to be referred to with variable names.
 * 
 * @author Steven J. Metsker
 */
public class CarryCommand extends Command 
{
	protected Term fromTerm;
	protected Term toTerm;
/**
 * Construct a "carry" command to carry a bin from
 * one machine to another.
 */
public CarryCommand(Term fromTerm, Term toTerm)
{
	this.fromTerm = fromTerm;
	this.toTerm = toTerm;
}
/**
 * Return true if the provided object equals this one.
 *
 * @return true if the provided object equals this one
 */
public boolean equals(Object o)
{
	if (o == this)
		return true;
	if (!(o instanceof CarryCommand))
		return false;
	CarryCommand c = (CarryCommand) o;
	return fromTerm.equals(c.fromTerm)
		&& toTerm.equals(c.toTerm);
}
/**
 * Evaulate this object's terms into machines, and carry a bin 
 * from the "from" machine to the "to" machine.
 */
public void execute(Context c)
{
	Machine m1 = fromTerm.eval(c);
	Machine m2 = toTerm.eval(c);
	Robot.getRobot().carry(m1, m2);
}
}