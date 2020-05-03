package com.oozinoz.machine;

import junit.framework.*;

/**
 * Test classes in the MachineComponent hierarchy.
 *
 * @author Steve Metsker
 */
public class TestMachine extends TestCase 
{
/**
 * Create an instance of this class with the given name. 
 *
 * @param name a name for these tests
 */
public TestMachine(String name)
{
	super(name);
}
/**
 * Return a tiny process flow that shows a composite that is
 * not a tree. In this flow m1 contains m2, m2 contains m3,
 * and m3 contains m1.
 */
public static MachineComponent cycle()
{
	MachineComposite m1 = new MachineComposite(1);
	MachineComposite m2 = new MachineComposite(2);
	MachineComposite m3 = new MachineComposite(3);
	m1.add(m2);
	m2.add(m3);
	m3.add(m1);
	return m1;
}
/**
 * Run the test- methods of this class.
 */
public static void main(String[] args)
{
	new junit.awtui.TestRunner().start(
		new String[] { "com.oozinoz.machine.TestMachine" });
}
/**
 * Return a tiny machine composite that shows a composite that is
 * not a tree. In this composite m1 contains m2 and m3, m2 
 * contains m3.
 * <blockquote><pre>
 * m1
 * |\
 * | m3
 * |/
 * m2
 * </pre></blockquote>
 */
public static MachineComponent nonTree()
{
	MachineComposite m1 = new MachineComposite(1);
	MachineComposite m3 = new MachineComposite(3);
	Machine m2 = new Fuser(2);
	m1.add(m2);
	m1.add(m3);
	m3.add(m2);
	return m1;
}
/**
 * Test that a cycle is not a tree.
 */
public void testCycle()
{
	assertEquals(false, cycle().isTree());
}
/**
 * Test that an acyclic graph that has a node with two
 * parents is not a tree.
 */
public void testNonTree()
{
	assertEquals(false, nonTree().isTree());
}
/**
 * Test that a machine is a tree.
 */
public void testOne()
{
	assertEquals(true, new Fuser(1).isTree());
}
/**
 * Test that the plant() example is not a tree.
 */
public void testPlant()
{
	assertEquals(false, OozinozFactory.plant().isTree());
}
/**
 * Test a normal little tree. 
 */
public void testTree()
{
	assertEquals(true, tree().isTree());
}
/**
 * Make a normal little tree.
 * <blockquote><pre>
 *   123
 *  /   \
 * 1     23
 *      /  \
 *     2    3
 * </pre></blockquote>
 */
public static MachineComposite tree()
{
	Machine m1 = new Fuser(1);
	Machine m2 = new Fuser(2);
	Machine m3 = new Fuser(3);
	MachineComposite m23 = new MachineComposite(23);
	m23.add(m2);
	m23.add(m3);
	MachineComposite m123 = new MachineComposite(123);
	m123.add(m1);
	m123.add(m23);
	return m123;
}
}