package com.oozinoz.machine;

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
 * Objects of this class represent either individual
 * machines or composites of machines.
 *
 * @author Steven J. Metsker
 *
 */
public abstract class MachineComponent
implements com.oozinoz.util.Iterable 
{
	protected int id = 0;

/**
 * Return the number of leaf node machines in this
 * composite.
 * 
 * @return the number of leaf node machines in this
 *         composite.
 */
public abstract int getMachineCount();
/**
 * Return true if this component is atop an acyclic graph
 * in which no node has two parents (two references to it).
 *
 * @return true if this component is atop an acyclic graph
 *              in which no node has two parents (two 
 *              references to it).
 */
public boolean isTree()
{
	return isTree(new HashSet());
}

/**
 * Return an iterator for this component.
 *
 * @return an iterator for this component
 */
public ComponentIterator iterator()
{
	return iterator(new HashSet());
}
/**
 * Return a textual representation of this component.
 *
 * @return a textual representation of this component
 */
public String toString()
{
	if (name != null)
	{
		return name;
	}
	String s = getClass().getName();
	return s.substring(s.lastIndexOf('.') + 1) + id;
}

	protected MachineComponent parent;
	protected Engineer responsible;

/**
 * Create a machine component with the given id and parent
 *
 * @param id this machine's identity
 * @param parent the machine composite that this component
 *               belongs to
 */
protected MachineComponent(
	int id,
	MachineComponent parent)
{
	this.id = id;
	this.parent = parent;
}

/**
 * Return true if, according to business rules, this
 * component and the supplied object refer to the same
 * thing.
 *
 * @return true if, according to business rules, this
 *              component and the supplied object refer to 
 *              the same thing.
 */
public boolean equals(Object o)
{
	if (o == this)
		return true;
	if (!(o instanceof MachineComponent))
		return false;
	MachineComponent mc = (MachineComponent) o;
	return id == mc.id;
}

/**
 * Return the engineer who is responsible for this machine.
 *
 * @return the engineer who is responsible for this machine
 */
public Engineer getResponsible()
{
	if (responsible != null)
	{
		return responsible;
	}
	if (parent != null)
	{
		return parent.getResponsible();
	}
	return null;
}

	protected String name;

/**
 * Create a machine component with the given id.
 *
 * @param id this machine's identity 
 */
protected MachineComponent(int id)
{
	this.id = id;
}

/**
 * This hook lets visitors add behaviors to the machine
 * composite.
 *
 * @param visitor a visitor that will add some sort of
 *                behavior
 */
public abstract void accept(MachineVisitor v);

/**
 * Return this component's id.
 * 
 * @return this component's id
 */
public int getId()
{
	return id;
}

/**
 * Return this component's name
 * 
 * @return this component's name
 */
public String getName()
{
	return name;
}

/**
 * Get the composite that this machine belongs to.
 *
 * @return the composite that this machine belongs to.
 */
public MachineComponent getParent()
{
	return parent;
}

/*
 * Subclasses implement this to support the isTree()
 * algorithm.
 */
protected abstract boolean isTree(Set s);

/**
 * Set this component's name
 * 
 * @param name this component's name
 */
public void setName(String name)
{
	this.name = name;
}
}