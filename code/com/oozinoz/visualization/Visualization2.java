package com.oozinoz.visualization;

import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
 * This extension adds a menu bar with Save and Load
 * items.
 * 
 * Like its superclass, this class expects a "machine.gif" 
 * file to lie in its classpath.
 * 
 * @author Steven J. Metsker
 */
public class Visualization2 extends Visualization 
{
	protected JFileChooser fc;
	protected JMenuBar menuBar;
	protected JMenu fileMenu;
protected JFileChooser fc()
{
	if (fc == null)
	{
		fc = new JFileChooser();
	}
	return fc;
}
protected JMenu fileMenu()
{
	if (fileMenu == null)
	{
		fileMenu = new JMenu("File");
		Font f = SwingFacade.getStandardFont();
		fileMenu.setFont(f);
		
		JMenuItem save = new JMenuItem("Save");
		save.setFont(f);
		fileMenu.add(save);
		save.addActionListener
			(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						save();
					}
				}
			);
		
		JMenuItem load = new JMenuItem("Load");
		load.setFont(f);
		fileMenu.add(load);
		load.addActionListener
			(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						load();
					}
				}
			);
	}
	return fileMenu;
}
protected void load()
{
	int dialogStatus = fc().showOpenDialog(null);
	if (dialogStatus == JFileChooser.APPROVE_OPTION)
	{
		File f = fc.getSelectedFile();
		try
		{
			ObjectInputStream in =
				new ObjectInputStream(new FileInputStream(f));
			List m = (List) in.readObject();
			in.close();
			mementos.removeAllElements();
			mementos.push(m);
			factory().restore(m);
			undoButton().setEnabled(false);
			vizPanel().repaint();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
/**
 * Show the addition of persistent storage to the 
 * visualization.
 */
public static void main(String[] args)
{
	Visualization2 v = new Visualization2();
	JFrame f =
		SwingFacade.launch(v.vizPanel(), " Mini Sim 2");
	f.setJMenuBar(v.menuBar());
	f.pack();
}
protected JMenuBar menuBar()
{
	if (menuBar == null)
	{
		menuBar = new JMenuBar();
		Menu fileMenu = new Menu("File");
		menuBar.add(fileMenu());
	}
	return menuBar;
}
protected void save()
{
	int status = fc().showSaveDialog(null);
	if (status == JFileChooser.APPROVE_OPTION)
	{
		File f = fc.getSelectedFile();
		try
		{
			ObjectOutputStream out =
				new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(mementos.peek());
			out.flush();
			out.close();
		}
		catch (IOException e)
		{
			// explain the problem and offer to try again
		}
	}
}
}