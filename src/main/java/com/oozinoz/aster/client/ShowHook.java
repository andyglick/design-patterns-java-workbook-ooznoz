package com.oozinoz.aster.client;

import com.oozinoz.aster.*;

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
 * Show how to use a hook from an AsterStarPress2 object.
 * 
 * @author Steven J. Metsker
 */
public class ShowHook 
{
/**
 * Show how to use a hook from an AsterStarPress2 object.
 */
public static void main(String[] args)
{
	AsterStarPress2 p = new AsterStarPress2();
	Hook h = new Hook()
	{
		public void execute(AsterStarPress2 p)
		{
			MaterialManager m = MaterialManager.getManager();
			m.setMoldIncomplete(p.getCurrentMoldID());
		}
	};
	p.setMarkMoldIncompleteHook(h);
}
}