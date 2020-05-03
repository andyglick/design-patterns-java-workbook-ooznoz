package com.oozinoz.process;

import junit.framework.*;

/**
 * Test classes in the com.oozinoz.process package.
 *
 * @author Steve Metsker
 */
public class TestProcess extends TestCase 
{
/**
 * Create an instance of TestProcess with the given name. 
 *
 * @param name a name for these tests
 */
public TestProcess(String name)
{
	super(name);
}
/**
 * Return a tiny process flow that shows a composite that is
 * not a tree. In this flow A contains C and B, B 
 * contains C.
 * <blockquote><pre>
 * a
 * |\
 * | b
 * |/
 * c
 * </pre></blockquote>
 */
public static ProcessComponent abc()
{
	ProcessSequence a = new ProcessSequence("a");
	ProcessSequence b = new ProcessSequence("b");
	ProcessStep c = new ProcessStep("c");
	a.add(c);
	a.add(b);
	b.add(c);
	return a;
}
/**
 * Return a tiny process flow that shows a composite that is
 * not a tree. In this flow A contains B, B contains C,
 * and C contains A.
 */
public static ProcessComponent cycle()
{
	ProcessSequence a = new ProcessSequence("a");
	ProcessSequence b = new ProcessSequence("b");
	ProcessSequence c = new ProcessSequence("c");
	a.add(b);
	b.add(c);
	c.add(a);
	return a;
}
/**
 * Run the test- methods of this class.
 */
public static void main(String[] args)
{
	new junit.awtui.TestRunner().start(
		new String[] { "com.oozinoz.process.TestProcess" });
}
/**
 * Test step count of a short little cycle that doesn't
 * have any steps.
 */
public void testCycle()
{
	assertEquals(0, cycle().getStepCount());
}
/**
 * Test step count for one step and one (empty) sequence.
 */
public void testOne()
{
	ProcessStep uno = new ProcessStep("uno");
	assertEquals(1, uno.getStepCount());
	ProcessSequence nil = new ProcessSequence("nil");
	assertEquals(0, nil.getStepCount());
}
/**
 * Test a process that repeats itself once, namely
 * "shampoo, rinse, repeat."
 */
public void testShampoo()
{
	ProcessStep shampoo = new ProcessStep("shampoo");
	ProcessStep rinse = new ProcessStep("rinse");
	ProcessSequence once = new ProcessSequence("once");
	once.add(shampoo);
	once.add(rinse);
	ProcessSequence instructions =
		new ProcessSequence("instructions");
	instructions.add(once);
	instructions.add(once);
	assertEquals(2, instructions.getStepCount());
}
/**
 * Test step count for the aerial shell process.
 */
public void testShell()
{
	assertEquals(4, ShellProcess.make().getStepCount());
}
/**
 * Test step count for a little directed acyclic graph that
 * is not a tree.
 */
public void testStepCount()
{
	assertEquals(1, abc().getStepCount());
}
/**
 * Test a normal little tree.
 * <blockquote><pre>
 *   abc
 *  /   \
 * a     bc
 *      /  \
 *     b    c
 * </pre></blockquote>
 */
public void testTree()
{
	ProcessStep a = new ProcessStep("a");
	ProcessStep b = new ProcessStep("b");
	ProcessStep c = new ProcessStep("c");
	ProcessSequence bc = new ProcessSequence("bc");
	bc.add(b);
	bc.add(c);
	ProcessSequence abc = new ProcessSequence("abc");
	abc.add(a);
	abc.add(bc);
	assertEquals(3, abc.getStepCount());
}
}