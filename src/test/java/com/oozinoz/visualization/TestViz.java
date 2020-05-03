package com.oozinoz.visualization;

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
 * This class exists primarily to show that you can apply
 * JUnit to GUI testing.
 * 
 * @author Steven J. Metsker
 */
public class TestViz extends junit.framework.TestCase 
{
/**
 * Constructs a test case with the given name.
 */
public TestViz(String name)
{
	super(name);
}
/**
 * Run the test- methods of this class.
 */
public static void main(String[] args)
{
	new junit.awtui.TestRunner().start(
		new String[] { "com.oozinoz.visualization.TestViz" });
}
/**
 * Test that the Undo button enables and disables
 * correctly.
 */
public void testUndoStates()
{
	Visualization v = new Visualization();
	assertEquals(false, v.undoButton().isEnabled());
	v.addMachine();
	assertEquals(true, v.undoButton().isEnabled());
	v.undo();
	assertEquals(false, v.undoButton().isEnabled());
}
}