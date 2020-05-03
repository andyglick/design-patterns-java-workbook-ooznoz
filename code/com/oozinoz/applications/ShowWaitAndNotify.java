package com.oozinoz.applications;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.oozinoz.machine.Bin;
import com.oozinoz.machine.BinStack;
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
 * Show an application that demonstrates the Object class's
 * wait() and notify() methods. The application loads and unloads
 * a stack of bins. If the stack is empty and the user clicks
 * Unload, the button disables and a thread waits for a bin
 * to be loaded. At this point, pressing Load briefly places
 * a bin on the stack before the waiting thread snatches it
 * away.
 * 
 * @author Steven J. Metsker 
 */
public class ShowWaitAndNotify implements ActionListener 
{
	private JButton loadButton;
	private JButton unloadButton;
	private JPanel mainPanel;
	private StackPanel stackPanel;
	private BinStack binStack;
/**
 * Fire up a thread to load or unload the stack, waiting
 * if necessary for the stack to be in an an appropriate
 * state.
 *
 * @param ActionEvent includes a clue as to which button
 *                    the user pressed
 */
public void actionPerformed(ActionEvent e)
{
	Object source = e.getSource();
	if (source.equals(loadButton()))
	{
		new Thread()
		{
			public void run()
			{
				loadButton().setEnabled(false);
				binStack().push(new Bin("a bin"));
				loadButton().setEnabled(true);
				stackPanel().repaint();
			}
		}
		.start();
	}
	if (source.equals(unloadButton()))
	{
		new Thread()
		{
			public void run()
			{
				unloadButton().setEnabled(false);
				binStack().pop();
				unloadButton().setEnabled(true);
				stackPanel().repaint();
			}
		}
		.start();
	}
}
protected BinStack binStack()
{
	if (binStack == null)
	{
		binStack = new BinStack();
	}
	return binStack;
}
protected JPanel buttonPanel()
{
	JPanel p1 = new JPanel();
	p1.setLayout(new BorderLayout());
	p1.add(loadButton(), "South");
	JPanel p2 = new JPanel();
	p2.setLayout(new BorderLayout());
	p2.add(p1, "Center");
	p2.add(unloadButton(), "South");
	return p2;
}
protected JButton loadButton()
{
	if (loadButton == null)
	{
		loadButton = new JButton("Load");
		loadButton.setFont(SwingFacade.getStandardFont());
		loadButton.addActionListener(this);
	}
	return loadButton;
}
/**
 * Show an application that demonstrates the Object class's
 * wait() and notify() methods. 
 */
public static void main(String[] args)
{
	ShowWaitAndNotify app = new ShowWaitAndNotify();
	SwingFacade.launch(app.mainPanel(), " Reach");
}
protected JPanel mainPanel()
{
	if (mainPanel == null)
	{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(buttonPanel(), "West");
		mainPanel.add(stackPanel(), "Center");
	}
	return mainPanel;
}
protected StackPanel stackPanel()
{
	if (stackPanel == null)
	{
		stackPanel = new StackPanel(binStack());
	}
	return stackPanel;
}
protected JButton unloadButton()
{
	if (unloadButton == null)
	{
		unloadButton = new JButton("Unload");
		unloadButton.setFont(SwingFacade.getStandardFont());
		unloadButton.addActionListener(this);
	}
	return unloadButton;
}
}