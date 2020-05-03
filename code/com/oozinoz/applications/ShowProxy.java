package com.oozinoz.applications;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.oozinoz.ui.*;
import com.oozinoz.imaging.*;

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
 * Show the use of ImageIconProxy. This application is
 * discussed in the "Proxy" chapter of the "Design Patterns
 * Java Workbook." We later tear out this code, preferring
 * the techniques used in the ImageIconLoader class.
 *
 * For this class to execute, an "images" directory must
 * be in the classpath, and this directory must contain
 * absent.jpg, loading.jpg, and fest.jpg.
 * 
 * @author Steven J. Metsker
 * @see ImageIconProxy
 * @see ImageIconLoader
 */
public class ShowProxy implements ActionListener 
{
	private ImageIconProxy proxy =
		new ImageIconProxy("fest.jpg");
	private JFrame frame;
	private JButton loadButton;

/**
 * Start loading the image and disable the Load button.
 */
public void actionPerformed(ActionEvent e) {
	proxy.load(frame);
	loadButton().setEnabled(false);
}
protected JButton loadButton() {
	if (loadButton == null) {
		loadButton = new JButton("Load");
		loadButton.addActionListener(this);
		loadButton.setFont(SwingFacade.getStandardFont());
	}
	return loadButton;
}
/**
 * Show the use of ImageIconProxy. 
 */
public static void main(String[] args)
{
	ShowProxy sp = new ShowProxy();
	sp.frame =
		SwingFacade.launch(sp.mainPanel(), " Proxy");
}
protected JPanel mainPanel() {
	JPanel p = new JPanel();
	p.setLayout(new BorderLayout());
	p.add("Center", new JLabel(proxy));
	p.add("South", loadButton());
	return p;
}
}