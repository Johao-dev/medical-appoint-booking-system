package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zuzz.projects.medical_appointment_booking_system.domain.exception.OverlappingSchedulesException;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DayOfWeek;

public class DoctorTest {

    private Doctor doctor;

    private List<Schedule> schedules = List.of(
        new Schedule(DayOfWeek.MONDAY, LocalTime.of(7, 0), LocalTime.of(8, 0)),
        new Schedule(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(14, 40)),
        new Schedule(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(13, 0)),
        new Schedule(DayOfWeek.THURSDAY, LocalTime.of(7, 50), LocalTime.of(9, 15)),
        new Schedule(DayOfWeek.FRIDAY, LocalTime.of(7, 0), LocalTime.of(8, 0)),
        new Schedule(DayOfWeek.SATURDAY, LocalTime.of(10, 30), LocalTime.of(12, 0))
    );

    @BeforeEach
    void setup() {
        doctor = new Doctor();
        schedules.forEach(doctor::addScheduleAvailability);
    }

    @Test
    void shouldAddScheduleAvailability() {
        Schedule schedule = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0));

        doctor.addScheduleAvailability(schedule);

        assertEquals(7, doctor.getScheduleAvailability().size());
        assertEquals(schedule, doctor.getScheduleAvailability().get(6));
    }

    @Test
    void shouldThrowOverlappingExceptionWhenTwoSameScheduleAreAdded() {
        Schedule schedule = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(7, 0),
            LocalTime.of(8, 0));
            
            assertThrows(OverlappingSchedulesException.class, () -> {
                doctor.addScheduleAvailability(schedule);
            });
        }
        
    @Test
    void shouldReturnTrueWhenAScheduleOverlapsWithOther() {
        Schedule occupiedSchedule = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(7, 0),
            LocalTime.of(8, 0));

        assertFalse(doctor.isAvailable(occupiedSchedule));
    }

    @Test
    void shouldRemoveScheduleAvailability() {
        Schedule schedule = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0));

        doctor.addScheduleAvailability(schedule);
        doctor.removeScheduleAvailability(schedule);

        assertEquals(6, doctor.getScheduleAvailability().size());
    }

    @Test
    void shuldThrowsNullPointerExceptionWhenScheduleIsNull() {
        Schedule schedule = null;

        assertThrows(NullPointerException.class, () -> {
            doctor.addScheduleAvailability(schedule);
        });
    }
}
