package com.oozinoz.visualization;

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


import org.assertj.core.api.Assertions;

/**
 * This class exists primarily to show that you can apply
 * JUnit to GUI testing.
 *
 * @author Steven J. Metsker
 */
public class TestViz {
    /**
     * Test that the Undo button enables and disables
     * correctly.
     */
    public void testUndoStates() {
        Visualization v = new Visualization();
        Assertions.assertThat(v.undoButton().isEnabled()).isFalse();
        v.addMachine();
        Assertions.assertThat(v.undoButton().isEnabled()).isTrue();
        v.undo();
        Assertions.assertThat(v.undoButton().isEnabled()).isFalse();
    }
}
