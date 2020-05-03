package com.oozinoz.recommend;

import java.util.*;
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
 * I just used this to create a little properties file with
 * a recommended rocket to promote in it.
 *
 * @author Steven J. Metsker
 */
public class WritePropertiesFile 
{

/**
 * Write a recommended rocket properties file.
 */
public static void main(String[] args) throws Exception {
	FileOutputStream out =
		new FileOutputStream("/strategy.dat");
	Properties p = new Properties(System.getProperties());
	p.setProperty("promote", "JSquirrel");
	p.store(out, "myheader");
	out.flush();
	out.close();
}
}