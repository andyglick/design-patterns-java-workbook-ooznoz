package com.oozinoz.applications;


import javax.swing.*;

import java.awt.Font;

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
 * Give a little demo of how JOptionPane lets you easily
 * produce a dialog panel.
 * 
 * @author Steven J. Metsker
 */
public class ShowOptionPane 
{
/**
 * Give a little demo of how JOptionPane lets you easily
 * produce a dialog panel.
 */
public static void main(String[] args)
{
	Font f = new Font("Dialog", Font.PLAIN, 18);
	UIManager.put("Button.font", f);
	UIManager.put("Label.font", f);

	int option;
	do {
		option =
			JOptionPane.showConfirmDialog(
				null,
				"Had enough?",
				" A Stubborn Dialog",
				JOptionPane.YES_NO_OPTION);
	}
	while (option == JOptionPane.NO_OPTION);
}
}