package com.oozinoz.machine;


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
 * This class provides object models of a few of Oozinoz's
 * factories, in terms of the factories' machines.
 *
 * @author Steven J. Metsker
 *
 */
public class OozinozFactory 
{










/**
 * Return a tiny factory that shows a composite that is
 * not a tree. In this factory A contains C and B, B 
 * contains C.
 * <blockquote><pre>
 * a
 * |\
 * | b
 * |/
 * c
 * </pre></blockquote>
 */
public static MachineComposite abc()
{
	Mediator m = new Mediator();
	MachineRoot a = new MachineRoot(100, new Engineer(4096));
	a.setName(" Factory Abc");
	MachineComposite b = new MachineComposite(101, a);
	Machine c = new Mixer(102, m, a);
	a.add(c);
	a.add(b);
	b.add(c);
	return a;
}

/**
 * Return a model of the machines in our Dublin facility.
 */
public static MachineComposite dublin()
{
	MachineRoot r = new MachineRoot(0, new Engineer(4096));
	r.setName(" Factory Dublin");
	Mediator m = new Mediator();
	r.add(line1(m, r));
	r.add(line2(m, r));
	r.add(line3(m, r));
	return r;
}

/**
 * Return a sample manufacturing line.
 *
 * @return a sample manufacturing line
 */
public static MachineComposite line1(
	Mediator m,
	MachineComposite parent)
{
	MachineComposite c = new MachineComposite(1000, parent);
	c.setName("Line 1");
	c.add(
		new Machine[] {
			new Mixer(1201, m, c),
			new StarPress(1401, m, c),
			new ShellAssembler(1301, m, c),
			new Fuser(1101, m, c)});
	return c;
}

/**
 * Return a second sample manufacturing line.
 *
 * @return a second sample manufacturing line
 */
public static MachineComposite line2(
	Mediator m,
	MachineComposite parent)
{
	MachineComposite c = new MachineComposite(2000, parent);
	c.setName("Line 2");
	c.add(
		new Machine[] {
			new Mixer(2201, m, c),
			new Mixer(2202, m, c),
			new StarPress(2401, m, c),
			new StarPress(2402, m, c),
			new ShellAssembler(2301, m, c),
			new Fuser(2101, m, c)});
	return c;
}

/**
 * Return a third sample manufacturing line.
 *
 * @return a third sample manufacturing line
 */
public static MachineComposite line3(
	Mediator m,
	MachineComposite parent)
{
	MachineComposite c = new MachineComposite(3000, parent);
	c.setName("Line 3");
	c.add(
		new Machine[] {
			new Mixer(3201, m, c),
			new Mixer(3202, m, c),
			new Mixer(3203, m, c),
			new Mixer(3204, m, c),
			new StarPress(3401, m, c),
			new StarPress(3402, m, c),
			new StarPress(3403, m, c),
			new StarPress(3404, m, c),
			new ShellAssembler(3301, m, c),
			new ShellAssembler(3302, m, c),
			new Fuser(3101, m, c),
			new Fuser(3102, m, c)});
	return c;
}

/**
 * Return a plant (a factory) that is not a tree.
 *
 * @return a plant (a factory) that is not a tree.
 */
public static MachineComposite plant()
{
	MachineComposite plant = new MachineComposite(100);
	MachineComposite bay = new MachineComposite(101);
	Machine m = new Mixer(102);
	Machine n = new StarPress(103);
	Machine o = new ShellAssembler(104);
	bay.add(m);
	bay.add(n);
	bay.add(o);
	plant.add(m);
	plant.add(bay);
	return plant;
}
}