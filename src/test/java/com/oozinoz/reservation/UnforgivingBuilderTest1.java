package com.oozinoz.reservation;

import org.junit.Test;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.fail;

/**
 * Test UnforgivingBuilder.
 *
 * @author Steve Metsker
 */
public class UnforgivingBuilderTest1 {
    /**
     * Test that we disallow a too low figure for dollars/head.
     */
    @Test
    public void testLowDollars() {
        String sample =
            "Date, November 5, Headcount, 250, "
                + "City, Springfield, DollarsPerHead, 1.95, "
                + "HasSite, No";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(sample);
        try {
            Reservation r = b.build();
        }
        catch (BuilderException e) {
            return;
        }
        fail("low dollars slipped through");
    }

    /**
     * Test that we disallow a too low figure for headcount.
     */
    @Test
    public void testLowHeadCount() {
        String s =
            "Date, November 5, Headcount, 2, "
                + "City, Springfield, DollarsPerHead, 9.95, "
                + "HasSite, No";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
        }
        catch (BuilderException e) {
            return;
        }
        fail("low head count slipped through");
    }

    /**
     * Test that we disallow missing dollars.
     */
    @Test
    public void testNoDollars() {
        String sample =
            "Date, November 5, Headcount, 250, "
                + "City, Springfield, "
                + "HasSite, No";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(sample);
        try {
            Reservation r = b.build();
        }
        catch (BuilderException e) {
            return;
        }
        fail("no dollars slipped through");
    }

    /**
     * Test that we disallow missing headcount.
     */
    @Test
    public void testNoHeadCount() {
        String s =
            "Date, November 5, "
                + "City, Springfield, DollarsPerHead, 9.95, "
                + "HasSite, No";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
        }
        catch (BuilderException e) {
            return;
        }
        fail("bad head count slipped through");
    }

    /**
     * Test a normal reservation.
     */
    @Test
    public void testNormal() throws BuilderException {
        String s =
            "Date, November 5, Headcount, 250, City, Springfield, "
                + "DollarsPerHead, 9.95, HasSite, No";
        UnforgivingBuilder b = new UnforgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        //
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(2000, Calendar.NOVEMBER, 5);
        ForgivingBuilderTest1.futurize(c);
        //
        Assertions.assertThat(c.getTime()).isEqualTo(r.date);
        Assertions.assertThat(r.headcount).isEqualTo(250);
        Assertions.assertThat(r.headcount * r.dollarsPerHead).isGreaterThanOrEqualTo(ReservationConstants.MINTOTAL);
        Assertions.assertThat(r.city).isEqualTo("Springfield");
        Assertions.assertThat(r.dollarsPerHead).isCloseTo(9.95, Offset.offset(.01));
        Assertions.assertThat(r.hasSite).isFalse();
    }

    /**
     * Test that we disallow missing city.
     */
    @Test
    public void testUnforgivingNoCity() {
        String s =
            "Date, November 5, Headcount, 250, "
                + "DollarsPerHead, 9.95, "
                + "HasSite, No";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
        }
        catch (BuilderException e) {
            return;
        }
        fail("bad city slipped through");
    }

    /**
     * Test that we disallow missing date.
     */
    @Test
    public void testUnforgivingNoDate() {
        String s =
            "Headcount, 250, "
                + "City, Springfield, DollarsPerHead, 9.95, "
                + "HasSite, No";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
        }
        catch (BuilderException e) {
            return;
        }
        fail("bad date slipped through");
    }
}
