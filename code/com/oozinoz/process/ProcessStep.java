package com.oozinoz.process;

import java.util.*;

import com.oozinoz.util.*;

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
 * Represent an individual process step.
 *
 * @author Steven J. Metsker
 *
 */
public class ProcessStep extends ProcessComponent 
{
/**
 * Create a step with the given name.
 *
 * @param id the name of this process step
 */
public ProcessStep(String name)
{
	super(name);
}



/**
 * This hook lets visitors add behaviors to the process
 * composite. The point here is to call back the visitor
 * indicating the type of this node, namely 
 * ProcessStep.
 *
 * @param visitor a visitor that will add some sort of
 *                behavior
 */
public void accept(ProcessVisitor v)
{
	v.visit(this);
}

/**
 * Return the number of steps in this step, namely 1
 *
 * @param visited components already visited while traversing
 *                this component
 * @return 1
 */
public int getStepCount(Set visited)
{
	visited.add(this);
	return 1;
}

/**
 * Return an iterator that will "iterate over" this step,
 * returning it once.
 *
 * @return an iterator that will "iterate over" this step,
 *         returning it once.
 */
public ComponentIterator iterator(Set visited)
{
	return new LeafIterator(this, visited);
}
}