package com.oozinoz.applications;

import java.util.*;

import com.oozinoz.units.*;
import com.oozinoz.fireworks.*;

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
 * Show how to sort a collection of objects.
 * 
 * @author Steven J. Metsker
 */
public class ShowComparator implements UnitConstants 
{
/**
 * Show how to sort a collection of objects.
 */
public static void main(String[] args)
{
	Rocket r1 =
		new Rocket("Mach-it", 22.95, (Length) METER.times(1000));
	Rocket r2 =
		new Rocket("Pocket", 2.95, (Length) METER.times(12));
	Rocket r3 =
		new Rocket("Sock-it", 9.95, (Length) METER.times(100));
	Rocket r4 =
		new Rocket("Sprocket", 3.95, (Length) METER.times(50));
	List rockets =
		Arrays.asList(new Rocket[] { r1, r2, r3, r4 });
	Comparator c = new Comparator()
		{
			public int compare(Object o1, Object o2)
			{
				Rocket r1 = (Rocket) o1;
				Rocket r2 = (Rocket) o2;
				double apogee1 = r1.getApogee().getMagnitude();
				double apogee2 = r2.getApogee().getMagnitude();
				return (int) (apogee1 - apogee2);
			}
	    };
	Collections.sort(rockets, c);
	Iterator i = rockets.iterator();
	while (i.hasNext())
	{
		System.out.println(i.next());
	}
}
}