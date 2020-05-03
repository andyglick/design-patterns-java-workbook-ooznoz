package com.oozinoz.applications;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.oozinoz.ui.*;

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
 * Show some nice borders, related to the point that you
 * can "decorate" without applying Decorator.
 * 
 * @author Steven J. Metsker
 */
public class ShowBorders 
{
protected static JButton createButton(String label)
{
	JButton b = new JButton(label);
	b.setFont(SwingFacade.getStandardFont());
	b.setFocusPainted(false);
	return b;
}
/**
 * Show some nice borders, related to the point that you
 * can "decorate" without applying Decorator.
 */
public static void main(String[] args)
{
	JButton ignite = createButton("Ignite");
	//
	JButton launch = createButton("Launch");
	launch.setBorder(
		new CompoundBorder(
			new LineBorder(Color.black, 4),
			new CompoundBorder(
				new BevelBorder(BevelBorder.RAISED),
				new EmptyBorder(10, 10, 10, 10))));
	JPanel p = new JPanel();
	p.add(ignite);
	p.add(launch);
	SwingFacade.launch(p, " Borders");
}
}