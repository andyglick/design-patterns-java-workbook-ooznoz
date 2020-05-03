package com.oozinoz.robot.interpreter;

import java.util.*;

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
 * This class contains a sequence of other commands.
 * 
 * @author Steven J. Metsker
 */
public class CommandSequence extends Command 
{
	protected List commands = new ArrayList();
/**
 * Add a command to the sequence of commands to which this
 * object will cascade an <code>execute</code> command.
 *
 * @param Command a command to add to this command sequence
 */
public void addCommand(Command c)
{
	commands.add(c);
}


/**
 * Returns a string description of this command sequence.
 *
 * @return   a string description of this command sequence
 */
public String toString()
{
	StringBuffer buf = new StringBuffer();
	boolean needLine = false;
	Iterator i = commands.iterator();
	while (i.hasNext())
	{
		if (needLine)
		{
			buf.append("\n");
		}
		buf.append(i.next());
		needLine = true;
	}
	return buf.toString();
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
	if (!(o instanceof CommandSequence))
		return false;
	CommandSequence cs = (CommandSequence) o;
	if (commands.size() != cs.commands.size())
	{
		return false;
	}
	Iterator i = commands.iterator();
	Iterator j = cs.commands.iterator();
	while (i.hasNext() && j.hasNext())
	{
		Command c1 = (Command) i.next();
		Command c2 = (Command) j.next();
		if (!c1.equals(c2))
		{
			return false;
		}
	}
	return true;
}

/**
 * Ask each command in the sequence to <code>execute</code>.
 */
public void execute(Context c)
{
	Iterator i = commands.iterator();
	while (i.hasNext())
	{
		((Command) i.next()).execute(c);
	}
}
}