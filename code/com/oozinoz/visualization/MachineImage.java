package com.oozinoz.visualization;

import javax.swing.ImageIcon;
import java.awt.Image;

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
 * This class supports a visualization (a picture) of
 * a machine in a factory.
 * 
 * @author Steven J. Metsker
 */
public class MachineImage
implements Cloneable, java.io.Serializable 
{
	protected transient Image image;
	protected String fileName;
	protected int x;
	protected int y;
/**
 * Construct a machine image using the graphic in the
 * supplied file name.
 *
 * @param fileName the file containing a picture of this
 *                 machine
 */
public MachineImage(String fileName)
{
	this.fileName = fileName;
}
/**
 * Return a copy of this machine image.
 *
 * @return a copy of this machine image
 */
public Object clone()
{
	try
	{
		return super.clone();
	}
	catch (CloneNotSupportedException e)
	{
		// this shouldn't happen, since we are Cloneable
		throw new InternalError();
	}
}
/**
 * Return the image used to portray a machine.
 *
 * @return the image used to portray a machine
 */
public java.awt.Image getImage()
{
	if (image == null)
	{
		java.net.URL url =
			ClassLoader.getSystemResource(fileName);
		image = new ImageIcon(url).getImage();
	}
	return image;
}
/**
 * Return the x location (in pixels) of this machine.
 *
 * @return the x location (in pixels) of this machine
 */
public int getX()
{
	return x;
}
/**
 * Return the y location (in pixels) of this machine.
 *
 * @return the y location (in pixels) of this machine
 */
public int getY()
{
	return y;
}
/**
 * Set the x location (in pixels) of this machine.
 *
 * @param int the x location (in pixels) of this machine
 */
public void setX(int x)
{
	this.x = x;
}
/**
 * Set the y location (in pixels) of this machine.
 *
 * @param int the y location (in pixels) of this machine
 */
public void setY(int y)
{
	this.y = y;
}
}