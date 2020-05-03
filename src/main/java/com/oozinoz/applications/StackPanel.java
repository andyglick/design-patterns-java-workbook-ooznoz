package com.oozinoz.applications;

import javax.swing.*;
import java.awt.*;
import com.oozinoz.machine.BinStack;

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
 * Displays a stack of bins.
 * 
 * @author Steven J. Metsker
 */
public class StackPanel extends JPanel 
{
	private BinStack binStack;
/**
 * Construct a panel that will portray a stack of bins.
 *
 * @param BinStack the bins to portray
 */
public StackPanel(BinStack binStack)
{
	this.binStack = binStack;
	setPreferredSize(
		new Dimension(100, 100 * BinStack.STACK_LIMIT));
}
protected void paintComponent(Graphics g)
{
	super.paintComponent(g);
	g.setColor(Color.yellow);
	for (int i = 0; i < binStack.size(); i++)
	{
		showBin(g, i);
	}
}
protected void showBin(Graphics g, int bin)
{
	// the basic trapezoidal shape of a bin
	int[] binX = new int[] { 10, 30, 70, 90 };
	int[] binY = new int[] { 20, 100, 100, 20 };
	// lifted to the height of the stack
	for (int j = 0; j < binY.length; j++)
	{
		binY[j] += (BinStack.STACK_LIMIT - bin - 1) * 100;
	}
	g.fillPolygon(binX, binY, binX.length);
}
}