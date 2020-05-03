package com.oozinoz.carousel;

import javax.swing.*;
import java.util.*;

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
 * Show the state of a carousel, in a label.
 * 
 * @author Steven J. Metsker
 * @see ShowCarousel
 */
public class CarouselLabel
extends JLabel implements Observer 
{


/**
 * Set the text of the label to indicate the carousel's
 * state, and repaint when the carousel changes.
 */
public void update(Observable o, Object arg)
{
	setText(carousel.status());
	repaint();
}

	private Carousel carousel;

/**
 * Construct a label that will observe the provided carousel.
 */
public CarouselLabel(Carousel carousel)
{
	this.carousel = carousel;
	setText(carousel.status());
	carousel.addObserver(this);
	setForeground(java.awt.Color.black);
}
}