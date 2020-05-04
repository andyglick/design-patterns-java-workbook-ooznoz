package com.oozinoz.reservation;

import org.junit.Test;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.fail;

/**
 * Test ForgivingBuilder.
 *
 * @author Steve Metsker
 */
public class ForgivingBuilderTest {
    /**
     * Push a date into the future by rolling forward the year.
     */
    public static void futurize(Calendar c) {
        Calendar now = Calendar.getInstance();
        while (c.before(now)) {
            c.add(Calendar.YEAR, 1);
        }
    }

    /**
     * Test that we disallow a too low figure for dollars/head.
     */
    @Test
    public void testLowDollars() {
        String s =
            "Date, November 5, Headcount, 250, "
                + "City, Springfield, DollarsPerHead, 1.95, "
                + "HasSite, No";
        ReservationBuilder b = new ForgivingBuilder();
        new ReservationParser(b).parse(s);
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
    public void testLowHeadCount() {
        String s =
            "Date, November 5, Headcount, 2, "
                + "City, Springfield, DollarsPerHead, 9.95, "
                + "HasSite, No";
        ReservationBuilder b = new ForgivingBuilder();
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
     * Test that we disallow a missing city.
     */
    public void testNoCity() {
        String s =
            "Date, November 5, Headcount, 250, "
                + "DollarsPerHead, 9.95, "
                + "HasSite, No";
        ReservationBuilder b = new ForgivingBuilder();
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
     * Test that we disallow a missing date.
     */
    public void testNoDate() {
        String s =
            "Headcount, 250, "
                + "City, Springfield, DollarsPerHead, 9.95, "
                + "HasSite, No";
        ReservationBuilder b = new ForgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
        }
        catch (BuilderException e) {
            return;
        }
        fail("bad date slipped through");
    }

    /**
     * Test that if there is a headcount but no dollars/head value, set the
     * dollars/head value to be high enough to generate the minimum take.
     */
    public void testNoDollar() throws BuilderException {
        String s =
            "Date, November 5, Headcount, 250, City, Springfield, "
                + "  HasSite, No";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        //
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(2000, Calendar.NOVEMBER, 5);
        futurize(c);
        //
        Assertions.assertThat(c.getTime()).isEqualTo(r.date);
        Assertions.assertThat(r.headcount).isEqualTo(250);
        Assertions.assertThat(r.headcount * r.dollarsPerHead).isGreaterThanOrEqualTo(ReservationConstants.MINTOTAL);
        Assertions.assertThat(r.city).isEqualTo("Springfield");
        Assertions.assertThat(r.hasSite).isFalse();
    }

    /**
     * Test that if there is no headcount but there is a dollars/head value,
     * set the headcount to be at least the minimum attendance and at least
     * enough to generate enough money for the event.
     */
    public void testNoHeadcount() throws BuilderException {
        String s =
            "Date, November 5,   City, Springfield, "
                + "DollarsPerHead, 9.95, HasSite, No";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        //
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(2000, Calendar.NOVEMBER, 5);
        futurize(c);
        //
        Assertions.assertThat(c.getTime()).isEqualTo(r.date);
        Assertions.assertThat(r.headcount)
            .isGreaterThanOrEqualTo(ReservationConstants.MINHEAD);
        Assertions.assertThat(r.headcount * r.dollarsPerHead)
            .isGreaterThanOrEqualTo(ReservationConstants.MINTOTAL);
        Assertions.assertThat(r.city).isEqualTo("Springfield");
        Assertions.assertThat(r.dollarsPerHead).isCloseTo(9.95, Offset.offset(.01));
        Assertions.assertThat(r.hasSite).isFalse();
    }

    /**
     * Test that if the reservation request specifies no headcount and no
     * dollars/head, set the headcount to the minimum and set dollars/head
     * to the minimum total divided by the headcount.
     */
    public void testNoHeadcountNoDollar() throws BuilderException {
        String s =
            "Date, November 5,   City, Springfield, "
                + "  HasSite, No";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        //
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(2000, Calendar.NOVEMBER, 5);
        futurize(c);
        //
        Assertions.assertThat(c.getTime()).isEqualTo(r.date);
        Assertions.assertThat(r.headcount).isEqualTo(ReservationConstants.MINHEAD);
        Assertions.assertThat(r.city).isEqualTo("Springfield");
        Assertions.assertThat(ReservationConstants.MINTOTAL / r.headcount)
            .isCloseTo(r.dollarsPerHead, Offset.offset(.01));
        Assertions.assertThat(r.hasSite).isFalse();
    }

    /**
     * Test a normal reservation.
     */
    public void testNormal() throws BuilderException {
        String s =
            "Date, November 5, Headcount, 250, City, Springfield, "
                + "DollarsPerHead, 9.95, HasSite, No";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        //
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(2000, Calendar.NOVEMBER, 5);
        futurize(c);
        //
        Assertions.assertThat(c.getTime()).isEqualTo(r.date);
        Assertions.assertThat(r.headcount).isEqualTo(250);
        Assertions.assertThat(r.city).isEqualTo("Springfield");
        Assertions.assertThat(r.dollarsPerHead).isCloseTo(9.95, Offset.offset(.01));
        Assertions.assertThat(r.hasSite).isFalse();
    }
}
