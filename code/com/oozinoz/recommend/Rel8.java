package com.oozinoz.recommend;

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
 * This class is just a mock-up, acting as if it were a
 * recommendation engine that relies on customer profiling
 * for its suggestions. 
 * <p>
 * See "Strategy" in "The Design Patterns Java Workbook."
 * 
 * @author Steven J. Metsker
 */
public class Rel8 
{
/**
 * Recommend a nice item for this customer, based on how
 * this customer's taste in music and extreme sports correlates
 * with other customers and with their fireworks preferences.
 */
public static Object advise(Customer c)
{
	return new Firework("demo", 1);
}
}