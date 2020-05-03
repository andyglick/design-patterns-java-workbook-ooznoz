package com.oozinoz.machine;

import junit.framework.*;
import com.oozinoz.chemical.Tub;
import java.util.*;

/**
 * Test Tub/Machine relations
 */
public class TestMediator extends TestCase 
{
	Mediator mediator = new Mediator();
	private StarPress sp_2402 = new StarPress(2402, mediator);
	private ShellAssembler sa_2301 =
		new ShellAssembler(2301, mediator);
	private Fuser f_2101 = new Fuser(2101, mediator);
	private Tub T20305 = new Tub("T20305", mediator);
	private Tub T20308 = new Tub("T20308", mediator);
	private Tub T25377 = new Tub("T25377", mediator);
	private Tub T25379 = new Tub("T25379", mediator);
	private Tub T25389 = new Tub("T25389", mediator);
	private Tub T27001 = new Tub("T27001", mediator);
	private Tub T27002 = new Tub("T27002", mediator);
/**
 * Create a test case with the provided name.
 */
public TestMediator(String name)
{
	super(name);
}
/**
 * Run the test- methods of this class.
 */
public static void main(String[] args)
{
	new junit.awtui.TestRunner().start(
		new String[] { "com.oozinoz.machine.TestMediator" });
}
/**
 * Set up the initial Tub/Machine relations.
 */
protected void setUp() throws Exception 
{
	super.setUp();
	T20305.setMachine(sp_2402);
	T20308.setMachine(sp_2402);
	T25377.setMachine(sa_2301);
	T25379.setMachine(sa_2301);
	T25389.setMachine(sa_2301);
	T27001.setMachine(f_2101);
	T27002.setMachine(f_2101);
}
/*
 * Test that we can move a tub and expect both machines
 * (where it was and where it went) to be updated (by
 * the mediator).
 */
public void testMove()
{
	// manual sets of tubs at star press, shell assembler, fuser
	Set sp = new HashSet();
	sp.add(T20305);
	sp.add(T20308);
	// shell assembler
	Set sa = new HashSet();
	sa.add(T25377);
	sa.add(T25379);
	sa.add(T25389);
	// fuser
	Set f = new HashSet();
	f.add(T27001);
	f.add(T27002);
	// check initial setup
	assertEquals(sp, sp_2402.getTubs());
	assertEquals(sa, sa_2301.getTubs());
	assertEquals(f, f_2101.getTubs());
	// move T20308 to fuser
	T20308.setMachine(f_2101);
	// update local sets by hand
	sp.remove(T20308);
	f.add(T20308);
	// check that (expected) manual moves match moves that mediator forced
	assertEquals(sp, sp_2402.getTubs());
	assertEquals(sa, sa_2301.getTubs());
	assertEquals(f, f_2101.getTubs());
}
/**
 * Test that the right tubs are at the star press.
 */
public void testTubsAtStarPress()
{
	Set s = new HashSet();
	s.add(T20305);
	s.add(T20308);
	assertEquals(s, sp_2402.getTubs());
}
}