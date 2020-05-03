package com.oozinoz.visualization;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Image;
import java.util.*;
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
 * This class lets a user draw a picture of an Oozinoz 
 * factory, adding machines here and there. The class is
 * not, at this point, actually tied to an underlying
 * simulation. That's because this class is really here to 
 * show how the Memento pattern can support an undo 
 * operation.
 *
 * Note that this class expects a "machine.gif" file to
 * lie in its classpath.
 * 
 * @author Steven J. Metsker
 */
public class Visualization
extends MouseInputAdapter
implements ActionListener 
{
	protected VizPanel vizPanel;
	protected JButton addButton;
	protected JButton undoButton;
	protected MachineImage gotOne = null;
	FactoryModel factory;
	protected Stack mementos;
/**
 * Create a new visualization (and set it up with an 
 * initial memento with no machines in it).
 */
public Visualization()
{
	factory = new FactoryModel();
	mementos = new Stack();
	mementos.add(factory.createMemento());
}
/**
 * React to the Add or Undo buttons.
 */
public void actionPerformed(ActionEvent e)
{
	Object source = e.getSource();
	if (source == addButton)
	{
		addMachine();
	}
	if (source == undoButton && !factory.isEmpty())
	{
		undo();
	}
}
protected JButton addButton()
{
	if (addButton == null)
	{
		addButton = new JButton("Add");
		addButton.setFont(SwingFacade.getStandardFont());
		addButton.addActionListener(this);
	}
	return addButton;
}
protected void addMachine()
{
	factory.addMachine(createImageHolder());
	undoButton.setEnabled(true);
	vizPanel().repaint();
	mementos.push(factory.createMemento());
}
protected MachineImage createImageHolder()
{
	return new MachineImage("machine.gif");
}
protected FactoryModel factory()
{
	return factory;
}
/**
 * Show an operational Undo button.
 */
public static void main(String[] args)
{
	Visualization v = new Visualization();
	JFrame f = SwingFacade.launch(v.vizPanel(), " Mini Sim");
}
/**
 * If an image is being dragged, repaint it.
 */
public void mouseDragged(MouseEvent e)
{
	int ex = e.getX();
	int ey = e.getY();
	if (gotOne != null)
	{
		Image i = gotOne.image;
		gotOne.x = ex - i.getWidth(vizPanel()) / 2;
		gotOne.y = ey - i.getHeight(vizPanel()) / 2;
		vizPanel().repaint();
	}
}
/**
 * The user clicked; it the mouse is inside a machine (image),
 * make that image current so it will be redrawn as the
 * user drags it.
 */
public void mousePressed(MouseEvent ev)
{
	int x = ev.getX();
	int y = ev.getY();
	Iterator i = factory.machines.iterator();
	while (i.hasNext())
	{
		MachineImage s = (MachineImage) i.next();
		Image im = s.image;
		if (x > s.x
			&& x < s.x + im.getWidth(vizPanel())
			&& y > s.y
			&& y < s.y + im.getHeight(vizPanel()))
		{
			gotOne = s;
			s.x = x - im.getWidth(vizPanel()) / 2;
			s.y = y - im.getHeight(vizPanel()) / 2;
			vizPanel().repaint();
			return;
		}
	}
	gotOne = null;
}
/**
 * The user let go of the mouse having clicked it; if he or
 * she was dragging a machine image, store a new memento
 * that records the state of the visualization.
 */
public void mouseReleased(MouseEvent e)
{
	if (gotOne != null)
	{
		mementos.push(factory.createMemento());
	}
}
/*
 * Go back to the last recorded state--the last memento.
 */
protected void undo()
{
	if (mementos.size() > 1)
	{
		mementos.pop();
		List m = (List) mementos.peek();
		factory().restore(m);
		undoButton().setEnabled(mementos.size() > 1);
		vizPanel().repaint();
	}
}
protected JButton undoButton()
{
	if (undoButton == null)
	{
		undoButton = new JButton("Undo");
		undoButton.setFont(SwingFacade.getStandardFont());
		undoButton.setEnabled(false);
		undoButton.addActionListener(this);
	}
	return undoButton;
}
protected VizPanel vizPanel()
{
	if (vizPanel == null)
	{
		vizPanel = new VizPanel(factory);
		vizPanel.add(addButton());
		vizPanel.add(undoButton());
		vizPanel.addMouseListener(this);
		vizPanel.addMouseMotionListener(this);
		vizPanel.setPreferredSize(new Dimension(300, 300));
	}
	return vizPanel;
}
}