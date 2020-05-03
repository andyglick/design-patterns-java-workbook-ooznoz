package com.oozinoz.visualization;





import javax.swing.*;

import java.awt.*;
import java.util.Iterator;

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
 * An instance of this class displays the machines in
 * a factory model.
 * 
 * @author Steven J. Metsker
 */
public class VizPanel extends JPanel 
{




















/**
 * Display the machines in the factory model.
 */
public void paintComponent(Graphics g)
{
	super.paintComponent(g); // paint the background
	Iterator i = factory.getMachines().iterator();
	while (i.hasNext())
	{
		MachineImage mi = (MachineImage) i.next();
		g.drawImage(mi.getImage(), mi.getX(), mi.getY(), this);
	}
}


	protected FactoryModel factory;

/**
 * Create a panel that will show the machines in the
 * supplied factory model.
 *
 * @param FactoryModel the factory to portray
 */
public VizPanel(FactoryModel factory)
{
	this.factory = factory;
}
}