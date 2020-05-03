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
 * Represent a collection of machines: a manufacturing line,
 * a bay, or a factory.
 *
 * @author Steven J. Metsker
 *
 */
public class MachineComposite extends MachineComponent 
{
	protected List components = new ArrayList();


/**
 * Add the given component as a child.
 *
 * @param component the component to add
 */
public void add(MachineComponent component)
{
	components.add(component);
}
/**
 * Return the number of machines (leaf nodes) in the tree
 * that this composite represents
 *
 * @return the number of machines (leaf nodes) in the
 *         tree that this composite represents
 */
public int getMachineCount()
{
	int count = 0;
	Iterator i = components.iterator();
	while (i.hasNext())
	{
		MachineComponent mc = (MachineComponent) i.next();
		count += mc.getMachineCount();
	}
	return count;
}



/**
 * Create a composite with the given id and with the 
 * supplied parent machine component.
 *
 * @param id the identity of this composite
 * @param parent the component that this machine belongs to
 */
public MachineComposite(int id, MachineComponent parent)
{
	super(id, parent);
}

/**
 * Create a composite with the given id, with the 
 * supplied parent machine component, and containing the
 * given components.
 *
 * @param id the identity of this composite
 * @param parent the component that this composite belongs to
 * @param components the children of this composite
 */
public MachineComposite(
	int id,
	MachineComponent parent,
	MachineComponent[] components)
{
	super(id, parent);
	for (int i = 0; i < components.length; i++)
	{
		add(components[i]);
	}
}

/**
 * Add the given components as children.
 *
 * @param children the components to add
 */
public void add(MachineComponent[] children)
{
	for (int i = 0; i < children.length; i++)
	{
		components.add(children[i]);
	}
}

/**
 * Create a composite with the given id.
 *
 * @param id the identity of this composite, such as the
 *           bay number
 */
protected MachineComposite(int id)
{
	this(id, null);
}

/**
 * This hook lets visitors add behaviors to the machine
 * composite. The point here is to call back the visitor
 * indicating the type of this node, namely 
 * MachineComposite.
 *
 * @param visitor a visitor that will add some sort of
 *                behavior
 */
public void accept(MachineVisitor v)
{
	v.visit(this);
}

/**
 * Return this composite's children.
 *
 * @return this composite's children
 */
public List getComponents()
{
	return components;
}

/**
 * Return true if this composite is a tree.
 *
 * @param visited a set of visited nodes
 * @return true if this composite is a tree
 * @see MachineComponent#isTree()
 */
protected boolean isTree(Set visited)
{
	visited.add(this);
	Iterator i = components.iterator();
	while (i.hasNext())
	{
		MachineComponent c = (MachineComponent) i.next();
		if (visited.contains(c) || !c.isTree(visited))
		{
			return false;
		}
	}
	return true;
}

/**
 * Return an iterator for this composite.
 *
 * @return an iterator for this composite
 */
public ComponentIterator iterator(Set visited)
{
	return new CompositeIterator(this, components, visited);
}
}