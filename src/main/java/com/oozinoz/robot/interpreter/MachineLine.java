package com.oozinoz.robot.interpreter;

import java.util.*;
import com.oozinoz.machine.*;

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
 * Provide some demo machines to work with.
 * 
 * @author Steven J. Metsker
 */
public class MachineLine 
{
private MachineLine()
{
}


	private static List machines;



private static List getMachines()
{
	if (machines == null)
	{
		MachineRoot r = new MachineRoot(0, new Engineer(4096));
		machines =
			Arrays.asList(
				new Machine[] {
					new Mixer(1201, r),
					new StarPress(1401, r),
					new ShellAssembler(1301, r),
					new Fuser(1101, r),
					new UnloadBuffer(1501, r)});
	}
	return machines;
}

private static void loadMachines()
{
	List machines = getMachines();
	// 2 bins each
	Iterator i = machines.iterator();
	while (i.hasNext())
	{
		Machine m = (Machine) i.next();
		while (m.hasMaterial())
		{
			m.unload();
		}
		m.addBin(new Bin("a.bin"));
		m.addBin(new Bin("another.bin"));
	}
}

/**
 * Return a context containing some demo machines.
 *
 * @return a context (a mapping of names to machines) that 
 * includes a mixer, a star press, a fuser, a shell
 * assembler, and an unload buffer.				
 */
public static Context createContext()
{
	getMachines();
	loadMachines();
	Context c = new Context();
	Iterator i = machines.iterator();
	while (i.hasNext())
	{
		Machine m = (Machine) i.next();
		c.assign(m.toString(), m);
	}
	return c;
}
}