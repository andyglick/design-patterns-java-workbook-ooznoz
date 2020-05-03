package com.oozinoz.imaging;

import java.awt.*;
import javax.swing.*;

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
 * This class acts as a proxy for another ImageIcon. In
 * "The Design Patterns Java Workbook" we  wind up tearing out
 * this class, preferring the techniques used in the 
 * ImageIconLoader class.
 * 
 * @author Steven J. Metsker
 
 * @see ImageIconLoader
 */
public class ImageIconProxy
	extends ImageIcon
	implements Runnable {
	static final ImageIcon ABSENT =
		new ImageIcon(
			ClassLoader.getSystemResource("absent.jpg"));
	static final ImageIcon LOADING =
		new ImageIcon(
			ClassLoader.getSystemResource("loading.jpg"));
	ImageIcon current = ABSENT;
	protected String filename;
	protected JFrame callbackFrame;
/**
 * Construct an ImageIconProxy that will (on demand) 
 * load the image in the provided file.
 *
 * @param filename the name of a file to load
 */
public ImageIconProxy(String filename)
{
	super(ABSENT.getImage());
	this.filename = filename;
}
/**
 * Get the height of the Icon
 */
public int getIconHeight()
{
	return current.getIconHeight();
}
/**
 * Get the width of the Icon
 */
public int getIconWidth()
{
	return current.getIconWidth();
}
/**
 * Load the desired image and call back the provided frame
 * when done.
 *
 * @param JFrame the frame to repaint when the image is loaded
 */
public void load(JFrame callbackFrame)
{
	this.callbackFrame = callbackFrame;
	current = LOADING;
	callbackFrame.repaint();
	new Thread(this).start();
}
/**
 * Paint the Icon
 */
public synchronized void paintIcon(
	Component c,
	Graphics g,
	int x,
	int y)
{
	current.paintIcon(c, g, x, y);
}
/**
 * Load the desired image (presumably in a separate thread). 
 */
public void run()
{
	current =
		new ImageIcon(
			ClassLoader.getSystemResource(filename));
	callbackFrame.pack();
}
}