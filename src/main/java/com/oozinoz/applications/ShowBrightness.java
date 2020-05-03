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
 * Show the brightness of a (fireworks) star.
 * 
 * @author Steven J. Metsker
 */
public class ShowBrightness 
{





/**
 * Show the brightness of a (fireworks) star.
 */
public static void main(String args[])
{
	FunPanel p = new FunPanel();
	p.setPreferredSize(new java.awt.Dimension(200, 200));
	//
	Function brightness =
		new Arithmetic(
			'*',
			new Exp(new Arithmetic('*', new Constant(-5), new T())),
			new Sin(
				new Arithmetic('*', new Constant(Math.PI), new T())));
	p.setXY(new T(), brightness);
	com.oozinoz.ui.SwingFacade.launch(p, " Brightness");
}

}