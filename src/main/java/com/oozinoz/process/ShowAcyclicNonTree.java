package com.oozinoz.process;

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
 * Show that an acyclic non-tree causes problems with algorithms
 * that assume a structure is a tree.
 *
 * @author Steven J. Metsker
 *
 */
public class ShowAcyclicNonTree 
{
/**
 * Show an error that occurs when a composite structure
 * that assumes it is a tree actually is not.
 */
public static void main(String[] args)
{
	ProcessComponent c = acyclicNonTree();
	System.out.println(c.getStepCount());
}

/**
 * Return a tiny process flow that is an acyclic non-tree.
 * <blockquote><pre>
 *  h
 *  |\
 *  | abc
 *  | /|\
 *  |/ | \
 *  a  b  c
 * 
 * </pre></blockquote>
 */
public static ProcessSequence acyclicNonTree()
{
	ProcessSequence h = new ProcessSequence("h");
	ProcessSequence abc = new ProcessSequence("abc");
	ProcessStep a = new ProcessStep("a");
	ProcessStep b = new ProcessStep("b");
	ProcessStep c = new ProcessStep("c");
	abc.add(a);
	abc.add(b);
	abc.add(c);
	h.add(a);
	h.add(abc);
	return h;
}
}