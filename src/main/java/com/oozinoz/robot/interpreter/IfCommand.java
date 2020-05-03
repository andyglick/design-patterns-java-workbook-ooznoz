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
 * This class represents an "if" statement that will execute
 * one of two commands depending on the value of a supplied
 * conditional term.
 * 
 * @author Steven J. Metsker
 */
public class IfCommand extends Command 
{
	protected Term term;
	protected Command body;
	protected Command elseBody;
/**
 * Construct an "if" command that will execute its "else" body
 * if the supplied term is null, and will otherwise execute
 * its regular body.
 *
 * @param Term the term to evaluate to determine which body to
 *             execute
 * @param Command the body to execute if the term is true
 * @param Command the body to execute if the term is false
 */
public IfCommand(
	Term term,
	Command body,
	Command elseBody)
{
	this.term = term;
	this.body = body;
	this.elseBody = elseBody;
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
	if (!(o instanceof IfCommand))
		return false;
	IfCommand ic = (IfCommand) o;
	return term.equals(ic.term) && body.equals(ic.body);
}
/**
 * Execute this object's "else" body if this object's term
 * evaluates to null; otherwise execute the main body.
 */
public void execute(Context c)
{
	if (term.eval(c) != null)
	{
		body.execute(c);
	}
	else
	{
		elseBody.execute(c);
	}
}
}