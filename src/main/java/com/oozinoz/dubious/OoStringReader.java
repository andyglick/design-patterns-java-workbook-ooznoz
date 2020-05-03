package com.oozinoz.dubious;

import java.io.*;

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
 * This class just shows that you could introduce subclasses
 * that humor the idea that Oozinoz has its own brand of
 * strings.
 * 
 * @author Steven J. Metsker
 */
public class OoStringReader extends StringReader 
{
/**
 * Construct a reader that can deal with getting
 * an OoString rather than a normal String object.
 *
 * @param OoString the OoString to deal with
 */
public OoStringReader(OoString ooString)
{
	super(ooString.getString());
}
}