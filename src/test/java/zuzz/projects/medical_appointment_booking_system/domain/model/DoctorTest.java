package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DayOfWeek;

public class DoctorTest {

    private Doctor doctor;

    @BeforeEach
    void setup() {
        // TODO: mapear correctamente
        doctor = new Doctor();
    }

    @Test
    void shouldAddScheduleAvailability() {
        Schedule schedule = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0)
        );

        doctor.addScheduleAvailability(schedule);

        assertEquals(1, doctor.getScheduleAvailability().size());
        assertEquals(schedule, doctor.getScheduleAvailability().get(0));
    }

    @Test
    void shouldRemoveScheduleAvailability() {
        Schedule schedule = new Schedule(
            DayOfWeek.MONDAY,
            LocalTime.of(9, 0),
            LocalTime.of(10, 0)
        );

        doctor.addScheduleAvailability(schedule);
        doctor.removeScheduleAvailability(schedule);

        assertEquals(0, doctor.getScheduleAvailability().size());
    }
}
