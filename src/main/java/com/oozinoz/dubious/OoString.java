package com.oozinoz.dubious;

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
 * This class provides a questionable extension to the String
 * class. See "Ordinary Extensions" in "The Design Patterns Java
 * Workbook" for more information.
 * 
 * @author Steven J. Metsker
 */
public class OoString 
{
	private String string;
/**
 * Construct an OoString.
 */
public OoString(String string)
{
	this.string = string;
}
/**
 * Return the underlaying or "backing" string.
 *
 * @return the underlaying or "backing" string
 */
public String getString() {
	return string;
}
/**
 * Make the case of this OoString "random," meaning that
 * its characters are uppercase or lowercase at random.
 */
public void setRandomCase() {
	StringBuffer buf = new StringBuffer();
	for (int i = 0; i < string.length(); i++) {
		char c = string.charAt(i);
		if (Math.random() > 0.5) {
			c = Character.toTitleCase(c);
		}
		buf.append(c);
	}
	string = buf.toString();
}
/**
 * Make the case of this OoString "titlecase," meaning that
 * its characters are uppercase if they follow whitespace.
 */
public void setTitleCase() {
	StringBuffer buf = new StringBuffer();
	boolean inWhite = true;
	for (int i = 0; i < string.length(); i++) {
		char c = string.charAt(i);
		if (Character.isWhitespace(c)) {
			inWhite = true;
		} else
			if (inWhite) {
				inWhite = false;
				c = Character.toTitleCase(c);
			}
		buf.append(c);
	}
	string = buf.toString();
}
/**
 * Return the underlying string.
 *
 * @return the underlying string
 */
public String toString() {
	return string;
}

/**
 * Convert all the characters of this OoString to lowercase.
 *
 * @return a version of this OoString with all lowercase
 *         characters
 */
public OoString toLowerCase() {
	return new OoString(string.toLowerCase());
}

/**
 * Convert all the characters of this OoString to uppercase.
 *
 * @return a version of this OoString with all uppercase
 *         characters
 */
public OoString toUpperCase() {
	return new OoString(string.toUpperCase());
}
}