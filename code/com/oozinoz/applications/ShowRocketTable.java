package com.oozinoz.applications;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

import com.oozinoz.fireworks.*;
import com.oozinoz.units.*;

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
 * Show a few rockets in a nice table. This code shows how
 * easy it is to adapt domain data for display in a Swing
 * table.
 * 
 * @author Steven J. Metsker
 */
public class ShowRocketTable implements UnitConstants 
{
/**
 * Show a few rockets in a nice table.  
 */
public static void main(String[] args)
{
	setFonts();
	JTable t = new JTable(getRocketTable());
	t.setRowHeight(36);
	JScrollPane jsp = new JScrollPane(t);
	jsp.setPreferredSize(new java.awt.Dimension(300, 100));
	display(jsp, " Rockets");
}

/**
 * Display a Swing component. We'll refactor this later
 * into a nice facade.
 *
 * @param Component the component to display
 * @param title the window title
 */
public static void display(Component c, String title)
{
	JFrame f = new JFrame(title);
	f.getContentPane().add(c);
	f.addWindowListener
		(
	        new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
	f.pack();
	f.setVisible(true);
}

private static RocketTable getRocketTable()
{
	Rocket r1 =
		new Rocket("Shooter", 3.95, (Length) METER.times(50));
	Rocket r2 =
		new Rocket("Orbit", 29.95, (Length) METER.times(5000));
	return new RocketTable(new Rocket[] { r1, r2 });
}

private static void setFonts()
{
	Font f = new Font("Dialog", Font.PLAIN, 18);
	UIManager.put("Table.font", f);
	UIManager.put("TableHeader.font", f);
}
}