package com.oozinoz.aster;

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
 * This class is a revision of the AsterStarPress class
 * that uses the Command pattern to let a client modify
 * its behavior.
 * <p>
 * The "Command" chapter in "The Design Patterns
 * Java Workbook" describes this class.
 * 
 * @author Steven J. Metsker
 */
public class AsterStarPress2 
{
	private int currentMoldID;

/**
 * Extrude all of the chemical paste (used for firework
 * stars) to waste area.
 */
public void dischargePaste()
{
}
/**
 * Spray water over the processing and discharge areas,
 * keeping the press from getting gunky.
 */
public void flush()
{
}
/**
 * Return true if the machine is processing a mold.
 *
 * @return true if the machine is processing a mold
 */
public boolean inProcess()
{
	return false;
}


/**
 * Stop processing, mark the current mold as incomplete,
 * move off all molds, discharge any prepared paste, and
 * flush the processing area with water.
 */
public void shutDown()
{
	if (inProcess())
	{
		stopProcessing();
		markMoldIncompleteHook.execute(this);
	}
	usherInputMolds();
	dischargePaste();
	flush();
}
/**
 * Stop the processing subassembly.
 */
public void stopProcessing()
{
}
/**
 * Move all molds to the output conveyor.
 */
public void usherInputMolds()
{
}

	private Hook markMoldIncompleteHook = new NullHook();

/**
 * Return the id of the mold currently being filled with
 * paste for stars.
 *
 * @return the id of the mold currently being filled with
 *         paste for stars
 */
public int getCurrentMoldID()
{
	return currentMoldID;
}

/**
 * Set the command to execute when the press stops partway
 * through processing a mold.
 *
 * @param Hook the command
 */
public void setMarkMoldIncompleteHook(Hook markMoldIncompleteHook)
{
	this.markMoldIncompleteHook = markMoldIncompleteHook;
}
}