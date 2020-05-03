package com.oozinoz.applications;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
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
 * Let a user change the location of a tub of chemicals. This
 * class is covered in the Mediator chapter where the class
 * is refactored into PlaceATub. The refactoring will
 * relieve this class of the responsibility for telling
 * interested components that the slider moved.
 * 
 * @author Steven J. Metsker
 */
public class PlaceATub_1
implements ActionListener, FocusListener 
{
	protected JTextField textField;
	protected List machineList;
	protected JPanel buttonPanel;
	protected JButton ok;
/**
 * React to the Ok button.
 *
 * @param ActionEvent ignored
 */
public void actionPerformed(ActionEvent e)
{
	textFieldChanged();
}
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
/**
 * The text field has focus; select its text so the user
 * can type over it.
 *
 * @param FocusEvent ignored
 */
public void focusGained(FocusEvent e)
{
	textField.selectAll();
}
/**
 * The text field lost focus and may have changed. Propogate
 * this information into the business domain.
 */
public void focusLost(FocusEvent e)
{
	textFieldChanged();
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
	PlaceATub_1 p = new PlaceATub_1();
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
		ok.addActionListener(this);
	}
	return ok;
}
protected JTextField textField()
{
	if (textField == null)
	{
		textField = new JTextField();
		textField.setFont(font());
		textField.addActionListener(this);
		textField.addFocusListener(this);
	}
	return textField;
}
/*
 * Here we would alert the business domain, and presumably
 * a database, of the tub location change.
 */
protected void textFieldChanged()
{
}
}