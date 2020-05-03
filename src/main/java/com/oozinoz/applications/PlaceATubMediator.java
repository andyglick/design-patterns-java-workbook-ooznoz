package com.oozinoz.applications;



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
 * Accept and dispatch events from the PlaceATub application.
 * 
 * @author Steven J. Metsker
 */
public class PlaceATubMediator
implements ActionListener, FocusListener 
{
	protected PlaceATub gui;

/**
 * React to the Ok button.
 *
 * @param ActionEvent ignored
 */
public void actionPerformed(ActionEvent e)
{
	textFieldChanged();
}
/**
 * The text field has focus; select its text so the user
 * can type over it.
 *
 * @param FocusEvent ignored
 */
public void focusGained(FocusEvent e)
{
	gui.textField().selectAll();
}
/**
 * The text field lost focus and may have changed. Propogate
 * this information into the business domain.
 */
public void focusLost(FocusEvent e)
{
	textFieldChanged();
}
/*
 * Here we would alert the business domain, and presumably
 * a database, of the tub location change.
 */
public void textFieldChanged()
{
}

/**
 * Construct a mediator to handle the events from the
 * supplied PlaceATub gui.
 *
 * @param gui the PlaceATub application whose events this
 *            mediator will manage
 */
public PlaceATubMediator(PlaceATub gui)
{
	this.gui = gui;
}
}