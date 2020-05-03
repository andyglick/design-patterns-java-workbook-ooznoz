package com.oozinoz.applications;


import java.awt.*;
import javax.swing.*;
import com.oozinoz.function.*;

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
 * Plots a curve given parametric functions x and y that
 * are parameterized on time t, where t goes 0 to 1 during
 * the life of the curve.
 * 
 * @author Steven J. Metsker
 */
public class FunPanel extends JPanel 
{



protected void paintComponent(Graphics g)
{
	super.paintComponent(g);
	double h = (double) (getHeight() - 1);
	double w = (double) (getWidth() - 1);
	for (int i = 0; i < nPoint; i++)
	{
		double t = ((double) i) / (nPoint - 1);
		xArray[i] = (int) (w * (fx.f(t) - xMin) / (xMax - xMin));
		yArray[i] =
			(int) (h - h * (fy.f(t) - yMin) / (yMax - yMin));
	}
	g.setColor(Color.black);
	g.drawPolyline(xArray, yArray, nPoint);
}

/**
 * Establish the functions to plot.
 *
 * @param fx the x function
 * @param fy the y function
 */
public void setXY(Function fx, Function fy)
{
	this.fx = fx;
	this.fy = fy;
	calculateExtrema();
	repaint();
}


	protected Function fx = new T();
	protected Function fy = new T();
	protected int nPoint = 101;
	protected int[] xArray = new int[nPoint];
	protected double xMax = 1;
	protected double xMin = 0;
	protected int[] yArray = new int[nPoint];
	protected double yMax = 1;
	protected double yMin = 0;

protected void calculateExtrema()
{
	for (int i = 0; i < nPoint; i++)
	{
		double t = ((double) i) / (nPoint - 1);
		double dx = fx.f(t);
		double dy = fy.f(t);
		if (i == 0 || dx > xMax)
		{
			xMax = dx;
		}
		if (i == 0 || dx < xMin)
		{
			xMin = dx;
		}
		if (i == 0 || dy > yMax)
		{
			yMax = dy;
		}
		if (i == 0 || dy < yMin)
		{
			yMin = dy;
		}
	}
}
}