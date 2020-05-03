package com.oozinoz.util;

import junit.framework.*;

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
 * Test the CommandUtil time() methodod.
 *
 * @author Steven J. Metsker
 *
 */
public class TestCommand extends TestCase 
{
/**
 * Create a test with the provided name.
 */
public TestCommand(String name)
{
	super(name);
}
/**
 * Run the test- methods of this class.
 */
public static void main(String[] args)
{
	new junit.awtui.TestRunner().start(
		new String[] { "com.oozinoz.util.TestCommand" });
}
/**
 * Test that a command to sleep for 2000 milliseconds in
 * fact sleeps about that long.
 */
public void testSleep()
{
	Command doze = new Command()
		{
			public void execute()
			{
				try
				{
			 	   Thread.sleep(2000);
				}
				catch (InterruptedException ignore)
				{
				}
			}
		};
	long t = CommandUtil.time(doze);
	assertEquals(2000, t, 50);
}
}