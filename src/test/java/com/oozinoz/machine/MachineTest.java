package com.oozinoz.machine;

import org.junit.Test;

import org.assertj.core.api.Assertions;

/**
 * Test classes in the MachineComponent hierarchy.
 *
 * @author Steve Metsker
 */
public class MachineTest {

    /**
     * Return a tiny process flow that shows a composite that is
     * not a tree. In this flow m1 contains m2, m2 contains m3,
     * and m3 contains m1.
     */
    public static MachineComponent cycle() {
        MachineComposite m1 = new MachineComposite(1);
        MachineComposite m2 = new MachineComposite(2);
        MachineComposite m3 = new MachineComposite(3);
        m1.add(m2);
        m2.add(m3);
        m3.add(m1);
        return m1;
    }

    /**
     * Return a tiny machine composite that shows a composite that is
     * not a tree. In this composite m1 contains m2 and m3, m2
     * contains m3.
     * <blockquote><pre>
     * m1
     * |\
     * | m3
     * |/
     * m2
     * </pre></blockquote>
     */
    public static MachineComponent nonTree() {
        MachineComposite m1 = new MachineComposite(1);
        MachineComposite m3 = new MachineComposite(3);
        Machine m2 = new Fuser(2);
        m1.add(m2);
        m1.add(m3);
        m3.add(m2);
        return m1;
    }

    /**
     * Make a normal little tree.
     * <blockquote><pre>
     *   123
     *  /   \
     * 1     23
     *      /  \
     *     2    3
     * </pre></blockquote>
     */
    public static MachineComposite tree() {
        Machine m1 = new Fuser(1);
        Machine m2 = new Fuser(2);
        Machine m3 = new Fuser(3);
        MachineComposite m23 = new MachineComposite(23);
        m23.add(m2);
        m23.add(m3);
        MachineComposite m123 = new MachineComposite(123);
        m123.add(m1);
        m123.add(m23);
        return m123;
    }

    /**
     * Test that a cycle is not a tree.
     */
    @Test
    public void testCycle() {
        Assertions.assertThat(cycle().isTree()).isFalse();
    }

    /**
     * Test that an acyclic graph that has a node with two
     * parents is not a tree.
     */
    @Test
    public void testNonTree() {
        Assertions.assertThat(nonTree().isTree()).isFalse();
    }

    /**
     * Test that a machine is a tree.
     */
    @Test
    public void testOne() {
        Assertions.assertThat(new Fuser(1).isTree()).isTrue();
    }

    /**
     * Test that the plant() example is not a tree.
     */
    @Test
    public void testPlant() {
        Assertions.assertThat(OozinozFactory.plant().isTree()).isFalse();
    }

    /**
     * Test a normal little tree.
     */
    @Test
    public void testTree() {
        Assertions.assertThat(tree().isTree()).isTrue();
    }
}
