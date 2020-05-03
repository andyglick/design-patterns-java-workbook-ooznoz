package com.oozinoz.recommend;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import com.oozinoz.fireworks.Firework;

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
 * Represents a customer.
 * 
 * @author Steven J. Metsker
 */
public class Customer 
{
/**
 * Return true if this customer has registered (or entered)
 * his or her preference profile.
 *
 * @return true if this customer has registered (or entered)
 *         his or her preference profile. This method is not
 *         actually implemented.
 */
public boolean isRegistered()
{
	return false;
}
/**
 * I just used this to ensure I was actually finding
 * the properties file that lists a strategic promotion.
 * If you set your classpath to include the "oozinoz"
 * directory that you can download from oozinoz.com, this
 * program will find the strategy.dat file that lists a
 * promoted firework. In short it's an example of finding
 * and reading from a properties file.
 */
public static void main(String[] args) throws Exception 
{
	new Customer().getRecommended();
}

/**
 * Return the amount of dough this customer has spent with
 * us since the provided date.
 *
 * @param Data what have you spent lately?
 * @return the amount of dough this customer has spent with
 *         us since the provided date; not actually implemented.
 */
public double spendingSince(Date date)
{
	return 1000;
}

	private Advisor advisor;
	public static final int BIG_SPENDER_DOLLARS = 1000;

private Advisor getAdvisor()
{
	if (advisor == null)
	{
		if (PromotionAdvisor.singleton.hasItem())
		{
			advisor = PromotionAdvisor.singleton;
		}
		else if (isRegistered())
		{
			advisor = GroupAdvisor.singleton;
		}
		else if (isBigSpender())
		{
			advisor = ItemAdvisor.singleton;
		}
		else
		{
			advisor = RandomAdvisor.singleton;
		}
	}
	return advisor;
}

/**
 * Return a firework to recommend to this customer.
 *
 * @return a firework to recommend to this customer
 */
public Firework getRecommended()
{
	// see if we're promoting a particular firework
	try
	{
		Properties p = new Properties();
		p.load(
			ClassLoader.getSystemResourceAsStream(
				"config/strategy.dat"));
		String promotedFireworkName = p.getProperty("promote");
		if (promotedFireworkName != null)
		{
			Firework f = Firework.lookup(promotedFireworkName);
			if (f != null)
			{
				return f;
			}
		}
	}
	catch (Exception e)
	{
	}
	// if registered, compare to other customers
	if (isRegistered())
	{
		return (Firework) Rel8.advise(this);
	}
	// check spending over the last year
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.YEAR, -1);
	if (spendingSince(cal.getTime()) > 1000)
	{
		return (Firework) LikeMyStuff.suggest(this);
	}
	// oh well!
	return Firework.getRandom();
}

/**
 * Return a firework to recommend to this customer.
 *
 * @return a firework to recommend to this customer. This
 *         method is refactored to employ the Strategy
 *         pattern.
 */
public Firework getRecommended_2()
{
	return getAdvisor().recommend(this);
}

private boolean isBigSpender()
{
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.YEAR, -1);
	return spendingSince(cal.getTime()) > BIG_SPENDER_DOLLARS;
}
}