package com.oozinoz.process;

import org.junit.Test;

import org.assertj.core.api.Assertions;

/**
 * Test classes in the com.oozinoz.process package.
 *
 * @author Steve Metsker
 */
public class TestProcess {
    /**
     * Return a tiny process flow that shows a composite that is
     * not a tree. In this flow A contains C and B, B
     * contains C.
     * <blockquote><pre>
     * a
     * |\
     * | b
     * |/
     * c
     * </pre></blockquote>
     */
    public static ProcessComponent abc() {
        ProcessSequence a = new ProcessSequence("a");
        ProcessSequence b = new ProcessSequence("b");
        ProcessStep c = new ProcessStep("c");
        a.add(c);
        a.add(b);
        b.add(c);
        return a;
    }

    /**
     * Return a tiny process flow that shows a composite that is
     * not a tree. In this flow A contains B, B contains C,
     * and C contains A.
     */
    public static ProcessComponent cycle() {
        ProcessSequence a = new ProcessSequence("a");
        ProcessSequence b = new ProcessSequence("b");
        ProcessSequence c = new ProcessSequence("c");
        a.add(b);
        b.add(c);
        c.add(a);
        return a;
    }

    /**
     * Test step count of a short little cycle that doesn't
     * have any steps.
     */
    @Test
    public void testCycle() {
        Assertions.assertThat(cycle().getStepCount()).isEqualTo(0);
    }

    /**
     * Test step count for one step and one (empty) sequence.
     */
    @Test
    public void testOne() {
        ProcessStep uno = new ProcessStep("uno");
        Assertions.assertThat(uno.getStepCount()).isEqualTo(1);

        ProcessSequence nil = new ProcessSequence("nil");
        Assertions.assertThat(nil.getStepCount()).isEqualTo(0);
    }

    /**
     * Test a process that repeats itself once, namely
     * "shampoo, rinse, repeat."
     */
    @Test
    public void testShampoo() {
        ProcessStep shampoo = new ProcessStep("shampoo");
        ProcessStep rinse = new ProcessStep("rinse");
        ProcessSequence once = new ProcessSequence("once");
        once.add(shampoo);
        once.add(rinse);
        ProcessSequence instructions =
            new ProcessSequence("instructions");
        instructions.add(once);
        instructions.add(once);
        Assertions.assertThat(instructions.getStepCount()).isEqualTo(2);
    }

    /**
     * Test step count for the aerial shell process.
     */
    @Test
    public void testShell() {
        Assertions.assertThat(ShellProcess.make().getStepCount())
            .isEqualTo(4);
    }

    /**
     * Test step count for a little directed acyclic graph that
     * is not a tree.
     */
    @Test
    public void testStepCount() {
        Assertions.assertThat(abc().getStepCount()).isEqualTo(1);
    }

    /**
     * Test a normal little tree.
     * <blockquote><pre>
     *   abc
     *  /   \
     * a     bc
     *      /  \
     *     b    c
     * </pre></blockquote>
     */
    @Test
    public void testTree() {
        ProcessStep a = new ProcessStep("a");
        ProcessStep b = new ProcessStep("b");
        ProcessStep c = new ProcessStep("c");
        ProcessSequence bc = new ProcessSequence("bc");
        bc.add(b);
        bc.add(c);
        ProcessSequence abc = new ProcessSequence("abc");
        abc.add(a);
        abc.add(bc);
        Assertions.assertThat(abc.getStepCount()).isEqualTo(3);
    }
}
