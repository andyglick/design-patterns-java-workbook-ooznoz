package com.oozinoz.applications;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.oozinoz.ballistics.Ballistics;
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
 * Show the standard burn rate and thrust equations. This
 * class is covered in the Observer chapter where the class
 * is refactored into ShowBallistics. The refactoring will
 * relieve this class of the responsibility for telling
 * interested components that the slider moved.
 * 
 * @author Steven J. Metsker
 */
public class ShowBallistics_2 
{
	protected BallisticsPanel_2 burnPanel;
	protected JSlider slider;
	protected double sliderMax;
	protected double sliderMin;
	protected BallisticsPanel_2 thrustPanel;
	protected JLabel valueLabel;
protected BallisticsPanel_2 burnPanel()
{
	if (burnPanel == null)
	{
		burnPanel =
			new BallisticsPanel_2(Ballistics.rate(), slider());
		burnPanel.setPreferredSize(new Dimension(300, 200));
	}
	return burnPanel;
}
/*
 * A panel to contain the two plots.
 */
protected JPanel curvePanel()
{
	JPanel p = new JPanel();
	p.setLayout(new GridLayout(1, 2));
	p.add(
		SwingFacade.createTitledPanel("Burn Rate", burnPanel()));
	p.add(
		SwingFacade.createTitledPanel("Thrust", thrustPanel()));
	return p;
}
/**
 * Show the standard burn rate and thrust equations.
 */
public static void main(String[] args)
{
	SwingFacade.launch(
		new ShowBallistics_2().mainPanel(),
		" Effects of tPeak");
}
/*
 * The main panel -- the one that actually gets displayed.
 */
protected JPanel mainPanel()
{
	JPanel p = new JPanel();
	p.setLayout(new BorderLayout());
	p.add(curvePanel(), "Center");
	p.add(sliderBox(), "South");
	return p;
}
protected JSlider slider()
{
	if (slider == null)
	{
		slider = new JSlider();
		sliderMax = slider.getMaximum();
		sliderMin = slider.getMinimum();
		slider.setValue(slider.getMinimum());
	}
	return slider;
}
/*
 * The box that holds the slider plus a textual label
 * and a changing label that shows the value of the
 * slider.
 */
protected Box sliderBox()
{
	Box b = Box.createHorizontalBox();
	JLabel label = new JLabel("tPeak");
	label.setFont(SwingFacade.getStandardFont());
	label.setBorder(
		BorderFactory.createEmptyBorder(0, 10, 0, 10));
	label.setForeground(java.awt.Color.black);
	b.add(label);
	b.add(valueLabel());
	b.add(slider());
	return b;
}
protected BallisticsPanel_2 thrustPanel()
{
	if (thrustPanel == null)
	{
		thrustPanel =
			new BallisticsPanel_2(Ballistics.thrust(), slider());
		thrustPanel.setPreferredSize(new Dimension(300, 200));
	}
	return thrustPanel;
}
protected JLabel valueLabel()
{
	if (valueLabel == null)
	{
		valueLabel = new BallisticsLabel_2(slider());
		valueLabel.setFont(SwingFacade.getStandardFont());
		valueLabel.setBorder(
			BorderFactory.createEmptyBorder(0, 10, 0, 10));
		valueLabel.setForeground(java.awt.Color.black);
	}
	return valueLabel;
}
}