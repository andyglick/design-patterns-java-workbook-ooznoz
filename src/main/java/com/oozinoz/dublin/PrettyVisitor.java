package com.oozinoz.dublin;

import java.util.*;
import com.oozinoz.process.*;

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
 * This class uses the visitor mechanics of the process
 * hierarchy to add a behavior that pretty-prints a
 * process composite. The prettiness is basically indentation,
 * although alternations are prefixed with a question mark
 * to note that they're alternations.
 *
 * This visitor takes care not to print any component twice, 
 * if the original component is cyclic. On encountering a node 
 * a second time, this visitor will print an ellipsis (...). 
 * 
 * @author Steven J. Metsker
 * @see com.oozinoz.applications.ShowPretty
 */
public class PrettyVisitor implements ProcessVisitor 
{
	public static int INDENT_DEPTH = 4;
	private StringBuffer buf;
	private int depth;
	private Set visited;
/*
 * Add the given composite's children to the output,
 * starting each child an indentation depth one greater 
 * than the current depth.
 */
protected void acceptChildren(ProcessComposite c)
{
	Iterator i = c.getSubprocesses().iterator();
	depth++;
	while (i.hasNext())
	{
		((ProcessComponent) i.next()).accept(this);
	}
	depth--;
}
/**
 * Returns a pretty (that is, indented) description of the
 * supplied process component.
 *
 * @param ProcessComponent the process component to portray
 * @return an indented description of the supplied process 
 *         component
 */
public StringBuffer getPretty(ProcessComponent pc)
{
	buf = new StringBuffer();
	visited = new HashSet();
	depth = 0;
	pc.accept(this);
	return buf;
}
/*
 * Print the "tag" of this composite, and print its children. The
 * tag is a possible prefix plus the name. If we've printed this
 * element before, just print an ellipsis.
 */
protected void printComposite(
	String tag,
	ProcessComposite c)
{
	if (visited.contains(c))
	{
		printTag(tag + "...");
	}
	else
	{
		visited.add(c);
		printTag(tag);
		acceptChildren(c);
	}
}
protected void printTag(String tag)
{
	for (int i = 0; i < depth * INDENT_DEPTH; i++)
	{
		buf.append(" ");
	}
	buf.append(tag);
	buf.append("\n");
}
/**
 * Add an alternation to the output buffer.
 */
public void visit(ProcessAlternation a)
{
	printComposite("?" + a.getName(), a);
}
/**
 * Add a sequence to the output buffer.
 */
public void visit(ProcessSequence s)
{
	printComposite(s.getName(), s);
}
/**
 * Add a step to the output buffer.
 */
public void visit(ProcessStep s)
{
	printTag(s.getName());
}
}