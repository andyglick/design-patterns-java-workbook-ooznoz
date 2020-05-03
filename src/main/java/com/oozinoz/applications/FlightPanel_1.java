package com.oozinoz.applications;

//import com.sun.java.swing.*;
import javax.swing.*;
import javax.swing.border.*;
//import java.util.*;
import java.awt.*;
import java.awt.event.*;

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
 * This class displays the flight path of a dud, but it needs 
 * refactoring. When you refactor it, you should see a facade 
 * emerge for displaying Swing components.
 * 
 * @author Steven J. Metsker
 */
public class FlightPanel_1 extends JPanel 
{
/**
 * Create a titled border with the given title.
 *
 * @param title the words to show in the title border tab
 * @return a (beveled) titled border with the given title
 */
public static TitledBorder createTitledBorder(String title)
{
	TitledBorder tb =
		BorderFactory.createTitledBorder(
			BorderFactory.createBevelBorder(BevelBorder.RAISED),
			title,
			TitledBorder.LEFT,
			TitledBorder.TOP);
	tb.setTitleColor(Color.black);
	tb.setTitleFont(getStandardFont());
	return tb;
}
/**
 * Create a new panel that wraps a titled border around a 
 * given panel.
 *
 * @param title the words to show in the title border tab
 * @param in the panel that the border goes around
 * @return a (beveled) titled border with the given title
 */
public static JPanel createTitledPanel(
	String title,
	JPanel in)
{
	//
	JPanel out = new JPanel();
	out.add(in);
	out.setBorder(createTitledBorder(title));
	return out;
}
/**
 * Create a standard font for GUI use.
 *
 * @return a standard font for GUI use
 */
public static Font getStandardFont()
{
	return new Font("Dialog", Font.PLAIN, 18);
}


/**
 * Show the flight path of a nonexploding aerial shell.  
 */
public static void main(String[] args)
{
	FlightPanel_1 fp = new FlightPanel_1();
	fp.setPreferredSize(new Dimension(300, 200));
	JPanel fp_titled =
		createTitledPanel("Flight Path", fp);
	//
	JFrame frame =
		new JFrame("Flight Path for Shell Duds");
	frame.getContentPane().add(fp_titled);
	frame.addWindowListener
		(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
	frame.pack();
	frame.setVisible(true);
}
protected void paintComponent(Graphics g)
{
	super.paintComponent(g); // paint the background 
	int nPoint = 101;
	double w = getWidth() - 1;
	double h = getHeight() - 1;
	int[] x = new int[nPoint];
	int[] y = new int[nPoint];
	for (int i = 0; i < nPoint; i++)
	{
		// t goes 0 to 1
		double t = ((double) i) / (nPoint - 1);
		// x goes 0 to w
		x[i] = (int) (t * w);
		// y is h at t = 0 and t = 1, and y is 0 at t = .5
		y[i] = (int) (4 * h * (t - .5) * (t - .5));
	}
	g.drawPolyline(x, y, nPoint);
}
}