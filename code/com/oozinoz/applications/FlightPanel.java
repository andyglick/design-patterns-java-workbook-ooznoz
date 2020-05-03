package com.oozinoz.applications;

//import com.sun.java.swing.*;
import javax.swing.*;

//import java.util.*;
import java.awt.*;


import com.oozinoz.simulation.FlightPath;

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
 * Displays the flight path of a dud.
 * 
 * @author Steven J. Metsker
 */
public class FlightPanel extends JPanel 
{
protected void paintComponent(Graphics g)
{
	super.paintComponent(g);
	// paint the background 
	int nPoint = 101;
	FlightPath fp =
		new FlightPath(getWidth() - 1, getHeight() - 1);
	g.drawPolyline(fp.getX(nPoint), fp.getY(nPoint), nPoint);
}
}