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
 * Show the flight path of a nonexploding shell, applying
 * reusable functions that apply the Decorator pattern.
 * 
 * @author Steven J. Metsker
 */
public class ShowFunFlight 
{





/**
 * Show the flight path of a nonexploding shell, applying
 * reusable functions that apply the Decorator pattern.
 */
public static void main(String args[])
{
	FunPanel p = new FunPanel();
	p.setPreferredSize(new java.awt.Dimension(200, 200));
	Function x = new T();
	//     y = 1 - 4 * (t - .5)**2;
	Function ft =
		new Arithmetic('-', new T(), new Constant(.5));
	Function y =
		new Arithmetic(
			'-',
			new Constant(1),
			new Arithmetic(
				'*',
				new Constant(4),
				new Arithmetic('*', ft, ft)));
	p.setXY(x, y);
	com.oozinoz.ui.SwingFacade.launch(p, " Flight Path");
}

}