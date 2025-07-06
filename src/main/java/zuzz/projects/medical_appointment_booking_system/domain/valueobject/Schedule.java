package zuzz.projects.medical_appointment_booking_system.domain.valueobject;

import java.time.LocalTime;

import zuzz.projects.medical_appointment_booking_system.shared.enums.DayOfWeek;

public class Schedule {

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
