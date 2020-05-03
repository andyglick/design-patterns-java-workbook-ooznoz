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
 * This class represents a "while" statement that will execute
 * its body so long as its term evaluates to a non-null value.
 *
 * @author Steven J. Metsker
 */
public class WhileCommand extends Command 
{
	protected Term term;
	protected Command body;
/**
 * Construct a "while" command that will execute its body
 * as long as the supplied term evaulates to a non-null value.
 *
 * @param Term the term to evaluate on each loop of the while
 * @param Command the body to execute 
 */
public WhileCommand(Term term, Command body)
{
	this.term = term;
	this.body = body;
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
	if (!(o instanceof WhileCommand))
		return false;
	WhileCommand wc = (WhileCommand) o;
	return term.equals(wc.term) && body.equals(wc.body);
}
/**
 * Evalulate this object's term; if it's not null,
 * execute the body. Repeat.
 */
public void execute(Context c)
{
	while (term.eval(c) != null)
	{
		body.execute(c);
	}
}
}