package com.oozinoz.applications;

import java.awt.BorderLayout;
import java.awt.Font;

import java.util.*;
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
 * Let a user change the location of a tub of chemicals.This
 * class is refactored from PlaceATub_. The changes
 * involve extracting event-related methods into a separate
 * mediator class.
 * 
 * @author Steven J. Metsker
 * @see PlaceATubMediator
 */
public class PlaceATub 
{
	protected PlaceATubMediator mediator;
	protected JTextField textField;
	protected List machineList;
	protected JPanel buttonPanel;
	protected JButton ok;
protected JComponent buttonPanel()
{
	if (buttonPanel == null)
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(ok(), "East");
	}
	return buttonPanel;
}
protected Font font()
{
	return SwingFacade.getStandardFont();
}
protected JComponent machineList()
{
	JList l =
		new JList(
			new String[] {
				"Mixer-2201",
				"Mixer-2202",
				"StarPress-2401",
				"StarPress-2402",
				"ShellAssembler-2301",
				"Fuser-2101" });
	l.setFont(font());
	return new JScrollPane(l);
}
/**
 * Let a user change the location of a tub of chemicals.
 */
public static void main(String[] args)
{
	PlaceATub p = new PlaceATub();
	SwingFacade.launch(p.mainPanel(), " Place a Tub");
}
protected JPanel mainPanel()
{
	JPanel p = new JPanel();
	p.setLayout(new BorderLayout());
	p.add(textField(), "North");
	p.add(machineList(), "Center");
	p.add(buttonPanel(), "South");
	return p;
}

protected JComponent ok()
{
	if (ok == null)
	{
		ok = new JButton("Ok!");
		ok.setFont(font());
		ok.addActionListener(mediator());
	}
	return ok;
}
protected JTextField textField()
{
	if (textField == null)
	{
		textField = new JTextField();
		textField.setFont(font());
		textField.addActionListener(mediator());
		textField.addFocusListener(mediator());
	}
	return textField;
}

protected PlaceATubMediator mediator()
{
	if (mediator == null)
	{
		mediator = new PlaceATubMediator(this);
	}
	return mediator;
}
}