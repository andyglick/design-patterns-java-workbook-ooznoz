package com.oozinoz.applications;

import javax.swing.*;
import javax.swing.event.*;

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
 * Instances of this class are labels that show the value
 * of a slider as a percentage of the slider's progress from
 * its minimum to its maximum.
 * 
 * @author Steven J. Metsker
 */
public class SliderLabel
extends JLabel implements ChangeListener 
{
/**
 * Update the label when the slider moves.
 *
 * @param e a ChangeEvent object
 */
public void stateChanged(ChangeEvent e)
{
	JSlider slider = (JSlider) e.getSource();
	double val = slider.getValue();
	double max = slider.getMaximum();
	double min = slider.getMinimum();
	double tp = (val - min) / (max - min);
	setText("" + tp);
}
}