package com.oozinoz.applications;

import javax.swing.table.*;

import com.oozinoz.fireworks.*;

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
 * Adapt a collection of rockets for display in a JTable.
 * 
 * @author Steven J. Metsker
 */
public class RocketTable extends AbstractTableModel 
{
	protected Rocket[] rockets;
	protected String[] columnNames =
		new String[] { "Name", "Price", "Apogee" };
/**
 * Construct a rocket table from an array of rockets.
 *
 * @param rockets an array of rockets
 */
public RocketTable(Rocket[] rockets)
{
	this.rockets = rockets;
}
/**
 * Return the number of columns in this table.
 * 
 * @return the number of columns in this table.
 */
public int getColumnCount()
{
	return columnNames.length;
}
/**
 * Return the name of the indicated column.
 *
 * @param index which column is interesting
 * @return the name of the indicated column
 */
public String getColumnName(int i)
{
	return columnNames[i];
}
/**
 * Return the number of rows in this table.
 * 
 * @return the number of rows in this table.
 */
public int getRowCount()
{
	return rockets.length;
}
/**
 * Return the value at the indicated row and column.
 *
 * @param row which row is interesting
 * @param col which column is interesting
 * @return the value at the indicated row and column.
 */
public Object getValueAt(int row, int col)
{
	switch (col)
	{
		case 0 :
			return rockets[row].getName();
		case 1 :
			return new Double(rockets[row].getPrice());
		case 2 :
			return new Double(
				rockets[row].getApogee().getMagnitude());
		default :
			return null;
	}
}
}