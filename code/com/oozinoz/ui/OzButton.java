package com.oozinoz.ui;

import javax.swing.JButton;

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
 * This class acts as a prototypical button that applications
 * can clone to get a standard look and feel.
 * 
 * @author Steven J. Metsker
 */
public class OzButton extends JButton 
{
/**
 * You might consider limiting constructor visibility
 * for a component like this to package visibility.
 */
OzButton()
{
}
/**
 * Return a copy of a prototypical button.
 *
 * @return a copy of a prototypical button
 */
public Object clone()
{
	OzButton b = new OzButton();
	b.setFont(getFont());
	b.setCursor(getCursor());
	return b;
}
}