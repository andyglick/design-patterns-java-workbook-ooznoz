package com.oozinoz.applications;

import java.awt.Dimension;
import javax.swing.*;
import com.oozinoz.ui.SwingFacade;

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
 * Show the flight path of a nonexploding shell.
 * 
 * @author Steven J. Metsker
 */
public class ShowFlightPanel 
{
/**
 * Show the flight path of a nonexploding shell.
 */
public static void main(String[] args)
{
	FlightPanel fp = new FlightPanel();
	fp.setPreferredSize(new Dimension(300, 200));
	JPanel p =
		SwingFacade.createTitledPanel("Flight Path", fp);
	SwingFacade.launch(p, "Flight Path for Shell Duds");
}
}