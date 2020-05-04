package com.oozinoz.util;

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

import org.junit.Test;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;

/**
 * Test the CommandUtil time() methodod.
 *
 * @author Steven J. Metsker
 */
public class CommandTest {

    /**
     * Test that a command to sleep for 2000 milliseconds in
     * fact sleeps about that long.
     */
    @Test
    public void testSleep() {
        Command doze = new Command() {
            public void execute() {
                try {
                    Thread.sleep(2000l);
                }
                catch (InterruptedException ignore) {
                }
            }
        };
        long t = CommandUtil.time(doze);
        Assertions.assertThat(t)
            .isCloseTo(2000l, Offset.offset(50l));
    }
}
