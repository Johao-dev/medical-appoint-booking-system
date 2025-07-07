package zuzz.projects.medical_appointment_booking_system.domain.valueobject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import zuzz.projects.medical_appointment_booking_system.shared.enums.DayOfWeek;

public class ScheduleTest {

    @Test
    void shouldReturnFalseWhenSchedulesDoNotOverlap_Before() {
        Schedule schedule1 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(10, 0),
            LocalTime.of(11, 0));

        Schedule schedule2 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(8, 0),
            LocalTime.of(9, 0));

        assertFalse(schedule1.overlapsWith(schedule2));
    }

    @Test
    void shouldReturnTrueWhenOverlapAtStart() {
        Schedule schedule1 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(11, 0));

        Schedule schedule2 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(8, 30),
            LocalTime.of(9, 30));

        assertTrue(schedule1.overlapsWith(schedule2));
    }

    @Test
    void shouldReturnTrueWhenOverlapAtEnd() {
        Schedule schedule1 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(11, 0));

        Schedule schedule2 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(10, 30),
            LocalTime.of(11, 30));

        assertTrue(schedule1.overlapsWith(schedule2));
    }

    @Test
    void shouldReturnTrueWhenOneScheduleIsInsideAnother() {
        Schedule schedule1 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(8, 0),
            LocalTime.of(12, 0));

        Schedule schedule2 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0));

        assertTrue(schedule1.overlapsWith(schedule2));
    }

    @Test
    void shouldReturnTrueWhenSchedulesAreIdentical() {
        Schedule schedule1 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0));

        Schedule schedule2 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0));

        assertTrue(schedule1.overlapsWith(schedule2));
    }

    @Test
    void shouldReturnFalseWhenSchedulesDoNotOverlap_After() {
        Schedule schedule1 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(8, 0),
            LocalTime.of(9, 0));

        Schedule schedule2 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 30),
            LocalTime.of(10, 30));

        assertFalse(schedule1.overlapsWith(schedule2));
    }

    @Test
    void shouldReturnFalseWhenSchedulesTouchAtEnd() {
        Schedule schedule1 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(8, 0),
            LocalTime.of(9, 0));

        Schedule schedule2 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0));

        assertFalse(schedule1.overlapsWith(schedule2));
    }

    @Test
    void shouldReturnFalseWhenSchedulesTouchAtStart() {
        Schedule schedule1 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(10, 0),
            LocalTime.of(11, 0));

        Schedule schedule2 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0));

        assertFalse(schedule1.overlapsWith(schedule2));
    }

    @Test
    void shouldReturnFalseWhenSchedulesAreOnDifferentDays() {
        Schedule schedule1 = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0));

        Schedule schedule2 = new Schedule(
            DayOfWeek.TUESDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0));

        assertFalse(schedule1.overlapsWith(schedule2));
    }
}