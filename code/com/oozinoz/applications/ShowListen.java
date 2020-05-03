package com.oozinoz.applications;

import com.oozinoz.ui.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

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
 * Show the dynamic addition of behavior to a button. The point
 * here is that this ability is different from the idea of the
 * Decorator pattern. The Decorator pattern's intent is to
 * provide for dynamic addition behavior through composition.
 * 
 * @author Steven J. Metsker 
 */
public class ShowListen 
{
protected static JButton createButton(String label)
{
	JButton b = new JButton(label);
	b.setFont(SwingFacade.getStandardFont());
	b.setFocusPainted(false);
	return b;
}
/**
 * Show the dynamic addition of behavior to a button.
 */
public static void main(String[] args)
{
	JPanel p = new JPanel();
	p.add(createButton("Normal"));
	final JButton b = createButton("Nifty");
	b.addMouseListener
		(
			new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					b.setBackground(Color.cyan);
					b.repaint();
				}
				public void mouseExited(MouseEvent e)
				{
					b.setBackground(Color.lightGray);
					b.repaint();
				}
			}
		);
	b.setBackground(Color.lightGray);
	p.add(b);
	SwingFacade.launch(p, " Rollover");
}
}