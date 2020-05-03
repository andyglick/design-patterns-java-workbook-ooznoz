package com.oozinoz.applications;

import javax.swing.JScrollPane;
import javax.swing.JTree;

import com.oozinoz.dublin.MachineTreeModel;
import com.oozinoz.machine.OozinozFactory;
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
 * Show the machine composite in use at our new plant
 * in Dublin.
 * 
 * @author Steven J. Metsker 
 */
public class ShowMachineTreeModel 
{
/**
 * Show the machine composite in use at our new plant
 * in Dublin.
 */
public static void main(String[] args)
{
	MachineTreeModel mtm =
		new MachineTreeModel(OozinozFactory.dublin());
	JTree tree = new JTree(mtm);
	tree.setFont(SwingFacade.getStandardFont());
	SwingFacade.launch(
		new JScrollPane(tree),
		" A New Oozinoz Factory");
}
}