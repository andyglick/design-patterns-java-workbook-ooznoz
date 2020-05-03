package com.oozinoz.carousel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

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
 * Portray a carousel's door.
 * 
 * @author Steven J. Metsker
 * @see ShowCarousel
 */
public class CarouselPanel
extends JPanel implements Observer
{


protected void paintComponent(Graphics g)
{
	super.paintComponent(g);
	int w = getWidth();
	int h = getHeight();
	int extent = (int) (w * carousel.getPercentClosed());
	g.setColor(Color.yellow);
	g.fillRect(0, 0, extent, h);
	g.setColor(Color.black);
	g.fillRect(extent, 0, w, h);
}
/**
 * Repaint the panel when the observed carousel changes.
 */
public void update(Observable o, Object arg)
{
	repaint();
}

	private Carousel carousel;











/**
 * Construct a panel that will portray a carousel's
 * door.
 */
public CarouselPanel(Carousel carousel)
{
	this.carousel = carousel;
	carousel.addObserver(this);
	setPreferredSize(new Dimension(300, 100));
}
}