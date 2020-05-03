package com.oozinoz.carousel;


import java.awt.*;
import java.awt.event.*;
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
 * Shows what the carousel door looks like. The "One Touch"
 * button changes the state of the door, depending on the
 * current state. See the "State" chapter of "The Design
 * Patterns Java Workbook" for details.
 * 
 * @author Steven J. Metsker
 */
public class ShowCarousel implements ActionListener 
{
	private Box buttonBox;

	private CarouselPanel doorPanel;
	private JPanel mainPanel;




/**
 * Let the carousel know that someone pushed its button.
 */
public void actionPerformed(ActionEvent e)
{
	carousel.click();
}
/*
 * A container for the status label and the "One Touch"
 * button.
 */
protected Box buttonBox()
{
	if (buttonBox == null)
	{
		buttonBox = Box.createHorizontalBox();
		buttonBox.add(status());
		buttonBox.add(Box.createHorizontalGlue());
		buttonBox.add(button());
	}
	return buttonBox;
}



/**
 * Shows what the carousel door looks like.  
 */
public static void main(String[] args)
{
	ShowCarousel app = new ShowCarousel();
	com.oozinoz.ui.SwingFacade.launch(
		app.mainPanel(),
		" Carousel");
	app.start();
}
/*
 * The panel that contains all the GUI components. 
 */
protected JPanel mainPanel()
{
	if (mainPanel == null)
	{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(doorPanel());
		mainPanel.add(buttonBox(), "South");
	}
	return mainPanel;
}



	private JButton button;
	private Carousel carousel = new Carousel();
	private JLabel status;

protected JButton button()
{
	if (button == null)
	{
		button = new JButton("One Touch");
		button.addActionListener(this);
	}
	return button;
}



protected void start()
{
	carousel.start();
}

protected JLabel status()
{
	if (status == null)
	{
		status = new CarouselLabel(carousel);
	}
	return status;
}

protected CarouselPanel doorPanel()
{
	if (doorPanel == null)
	{
		doorPanel = new CarouselPanel(carousel);
	}
	return doorPanel;
}
}