package com.oozinoz.applications;

import javax.swing.*;

import java.util.*;
import com.oozinoz.ballistics.Tpeak;

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
 * of a Tpeak model.
 * 
 * @author Steven J. Metsker
 */
public class BallisticsLabel
extends JLabel implements Observer 
{
/**
 * Construct a label that will show the value of a Tpeak
 * object.
 *
 * @param tPeak the model to observe
 */
public BallisticsLabel(Tpeak tPeak)
{
	tPeak.addObserver(this);
}
/**
 * Respond to a change in the observed Tpeak model
 *
 * @param Observable presumably the model we are observing
 * @param arg ignored
 */
public void update(Observable o, Object arg)
{
	setText("" + ((Tpeak) o).getValue());
//	repaint();
}
}