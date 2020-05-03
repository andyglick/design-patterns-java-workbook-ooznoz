package com.oozinoz.machine;

import org.junit.Before;
import org.junit.Test;

import org.assertj.core.api.Assertions;

import com.oozinoz.chemical.Tub;

import java.util.HashSet;
import java.util.Set;

/**
 * Test Tub/Machine relations
 */
public class MediatorTest1 {
    Mediator mediator = new Mediator();
    private final Tub t20305 = new Tub("t20305", mediator);
    private final Tub t20308 = new Tub("t20308", mediator);
    private final Tub t25377 = new Tub("t25377", mediator);
    private final Tub t25379 = new Tub("t25379", mediator);
    private final Tub t25389 = new Tub("t25389", mediator);
    private final Tub t27001 = new Tub("t27001", mediator);
    private final Tub t27002 = new Tub("t27002", mediator);
    private StarPress sp_2402 = new StarPress(2402, mediator);
    private ShellAssembler sa_2301 =
        new ShellAssembler(2301, mediator);
    private Fuser f_2101 = new Fuser(2101, mediator);

    /**
     * Set up the initial Tub/Machine relations.
     */
    @Before
    public void setUp() {
        t20305.setMachine(sp_2402);
        t20308.setMachine(sp_2402);
        t25377.setMachine(sa_2301);
        t25379.setMachine(sa_2301);
        t25389.setMachine(sa_2301);
        t27001.setMachine(f_2101);
        t27002.setMachine(f_2101);
    }

    /*
     * Test that we can move a tub and expect both machines
     * (where it was and where it went) to be updated (by
     * the mediator).
     */
    public void testMove() {
        // manual sets of tubs at star press, shell assembler, fuser
        Set<Tub> sp = new HashSet<>();
        sp.add(t20305);
        sp.add(t20308);
        // shell assembler
        Set<Tub> sa = new HashSet<>();
        sa.add(t25377);
        sa.add(t25379);
        sa.add(t25389);
        // fuser
        Set<Tub> f = new HashSet<>();
        f.add(t27001);
        f.add(t27002);
        // check initial setup
        Assertions.assertThat(sp_2402.getTubs()).isEqualTo(sp);
        Assertions.assertThat(sa_2301.getTubs()).isEqualTo(sa);
        Assertions.assertThat(f_2101.getTubs()).isEqualTo(f);
        // move t20308 to fuser
        t20308.setMachine(f_2101);
        // update local sets by hand
        sp.remove(t20308);
        f.add(t20308);
        // check that (expected) manual moves match moves that mediator forced
        Assertions.assertThat(sp_2402.getTubs()).isEqualTo(sp);
        Assertions.assertThat(sa_2301.getTubs()).isEqualTo(sa);
        Assertions.assertThat(f_2101.getTubs()).isEqualTo(f);
    }

    /**
     * Test that the right tubs are at the star press.
     */
    @Test
    public void testTubsAtStarPress() {
        Set<Tub> s = new HashSet<>();
        s.add(t20305);
        s.add(t20308);
        Assertions.assertThat(sp_2402.getTubs()).isEqualTo(s);
    }
}
