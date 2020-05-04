package com.oozinoz.units;

import org.junit.Test;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;

/**
 * Test classes in the com.oozinoz.units package.
 *
 * @author Steve Metsker
 */
public class UnitsTest implements UnitConstants {
    /*
     * Just here to check that type-checking works.
     */
    private void setArea(Area a) {
        /**
         * it's EMPTY EMPTY EMPTY
         */
    }

    /**
     * Test acceleration units.
     */
    @Test
    public void testAcceleration() {
        Acceleration a =
            (Acceleration) FEET.times(32.17).divide(SECOND).divide(SECOND);

        Assertions.assertThat(a.getDimension()).isEqualTo(G.getDimension());
        Assertions.assertThat(a.getMagnitude()).isCloseTo(G.getMagnitude(), Offset.offset(.01));
    }

    /**
     * Test area units.
     */
    @Test
    public void testArea() {
        Constant c = (Constant) MILE.times(MILE).divide(ACRE);
        Assertions.assertThat(c.magnitude).isCloseTo(640, Offset.offset(.1));
    }

    /**
     * Test code in comments in this package.
     */
    @Test
    public void testComments() {
        // UnitConstants
        Length radius = (Length) METER.times(350);
        setArea((Area) radius.times(radius).times(Math.PI));
        // Measure
        Area a = (Area) INCH.times(INCH).times(.75);
    }

    /**
     * Test some conversions.
     */
    @Test
    public void testConversion() {
        Measure m;
        m = (Area) INCH.times(INCH);
        m = (Area) GALLON.divide(FOOT);
        m = (Energy) POUND.times(METER);
    }

    /**
     * Test how many feet are in a mile.
     */
    @Test
    public void testFeetInAMile() {
        Constant c = (Constant) MILE.divide(FOOT);
        Assertions.assertThat(c.magnitude).isCloseTo(5280, Offset.offset(.1));
    }

    /**
     * Test power units.
     */
    @Test
    public void testPower() {
        Constant c = (Constant) HORSEPOWER.divide(WATT);
        Assertions.assertThat(c.getMagnitude()).isCloseTo(745.7, Offset.offset(.1));
    }

    /**
     * Test the Measure.round() function.
     */
    @Test
    public void testRound() {
        Assertions.assertThat(Measure.round(1234.5678, 2))
            .isCloseTo(1200, Offset.offset(.01));
        Assertions.assertThat(Measure.round(1234.5678, 6))
            .isCloseTo(1234.57, Offset.offset(.01));
        Assertions.assertThat(Measure.round(1234.5678, 8))
            .isCloseTo(1234.5678, Offset.offset(.01));

        Assertions.assertThat(Measure.round(.000333333, 2))
            .isCloseTo(.00033, Offset.offset(.000001));

        Assertions.assertThat(Measure.round(1234.001, 4))
            .isCloseTo(1234.0, Offset.offset(.000001));
    }

    /**
     * Test volume units.
     */
    @Test
    public void testVolume() {
        final Volume CUBIC_INCH = (Volume) INCH.times(INCH).times(INCH);
        Constant c;
        c = (Constant) GALLON.divide(CUBIC_INCH);
        Assertions.assertThat(c.magnitude).isCloseTo(231, Offset.offset(.1));
        c = (Constant) LITER.divide(CUBIC_INCH);
        Assertions.assertThat(c.magnitude).isCloseTo(61, Offset.offset(.1));
    }

    /**
     * Test weight units.
     */
    @Test
    public void testWeight() {
        Force myWeight = (Force) POUND.times(180);
        double tolerance = .5;
        // note that to model a kilogram on Earth you must
        // accelerate it in accordance with the Earth's gravity
        Assertions.assertThat(myWeight.equals(KILOGRAM.times(G).times(81.6), tolerance))
            .isTrue();
    }
}
