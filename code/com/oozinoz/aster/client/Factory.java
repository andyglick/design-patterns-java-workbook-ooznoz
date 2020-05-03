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
 * This class is just here to let the mocked-up
 * OzAsterStarPress class act as though it can get a
 * factory singleton.
 * 
 * @author Steven J. Metsker
 */
public class Factory 
{

/**
 * Not implemented; if it were this method would send
 * a robot over to collect paste from the discharge
 * area of an Aster star press.
 */
public void collectPaste(AsterStarPress asp)
{
}
/**
 * Not actually implemented.
 */
public static Factory getFactory()
{
	return null;
}
}