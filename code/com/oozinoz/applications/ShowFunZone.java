package com.oozinoz.applications;







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
 * Show the landing zone of a nonexploding shell. The point
 * is actually that by applying function decorators we can
 * plot a vast variety of functions without creating new
 * function classes or a new type of panel to display them.
 * 
 * @author Steven J. Metsker
 */
public class ShowFunZone 
{





/**
 * Show the landing zone of a dud.
 */
public static void main(String args[])
{
	FunPanel p = new FunPanel();
	p.setPreferredSize(new java.awt.Dimension(200, 200));
	Function theta =
		new Arithmetic('*', new Constant(2 * Math.PI), new T());
	Function x = new Cos(theta);
	Function y = new Sin(theta);
	p.setXY(x, y);
	com.oozinoz.ui.SwingFacade.launch(p, " Dud Zone");
}

}