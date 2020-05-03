package com.oozinoz.fireworks;

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
 * This interface defines constants that classify fireworks. In 
 * the United States, fireworks are classified as either 
 * "consumer" fireworks, or as "display" fireworks. Only 
 * consumer fireworks can be purchased and used without a 
 * license. States vary considerably in their decisions 
 * regarding which types of fireworks are "consumer" fireworks.
 */
public interface ClassificationConstants {
	static final Classification CONSUMER =
		new Classification(); 
	static final Classification DISPLAY =
		new Classification(); 
}