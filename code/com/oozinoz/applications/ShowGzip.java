package com.oozinoz.applications;

import java.io.*;
import java.util.zip.*;

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
 * Show how to wrap a zipping stream around a file stream to
 * compress a file.
 * 
 * @author Steven J. Metsker
 */
public class ShowGzip 
{
/**
 * Show how to wrap a zipping stream around a file stream to
 * compress a file.
 */
public static void main(String args[])
throws IOException 
{
	String fileName = "demo.doc";
	java.net.URL url =
		ClassLoader.getSystemResource(fileName);
	InputStream in = url.openStream();
	GZIPOutputStream out =
		new GZIPOutputStream(
			new FileOutputStream(url.getFile() + ".gz"));
	byte[] data = new byte[100];
	while (true)
	{
		int n = in.read(data);
		if (n == -1)
		{
			break;
		}
		out.write(data, 0, n);
	}
	out.close();
	in.close();
}
}