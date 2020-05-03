package com.oozinoz.process;



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
 * This interface defines the type of object that process 
 * steps and process composites will accept. The 
 * ProcessComponent hierarchy classes call back a visiting 
 * object's visit() methods; In so doing they identify their 
 * type. Implementors of this interface can create algorithms 
 * that operate differently on different type of process 
 * components. 
 *
 * @author Steven J. Metsker
 *
 */
public interface ProcessVisitor {





/**
 * Visit a process alternation.
 *
 * @param ProcessAlternation the process alternation to visit
 */
void visit(ProcessAlternation a);

/**
 * Visit a process sequence.
 *
 * @param ProcessSequence the process sequence to visit
 */
void visit(ProcessSequence s);

/**
 * Visit a process step.
 *
 * @param ProcessStep the process step to visit
 */
void visit(ProcessStep s);
}