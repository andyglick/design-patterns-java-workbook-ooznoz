package com.oozinoz.ui;

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
 * This class suggests the idea of an abstract kit that
 * subclasses can fill out to create user interface
 * standards for different types of devices or different
 * versions of an application.
 * 
 * @author Steven J. Metsker
 */
public abstract class ComponentKit 
{
/**
 * Return a standard background panel.
 *
 * @return a standard background panel
 */
public abstract OzBackPanel createBackPanel();
/**
 * Return a standard button.
 *
 * @return a standard button
 */
public abstract OzButton createButton();
/**
 * Return a standard text area
 *
 * @return a standard text area
 */
public abstract OzTextArea createTextArea();
/**
 * Return a standard titled text area.
 *
 * @return a standard titled text area
 */
public abstract OzTitledArea createTitledArea();
}