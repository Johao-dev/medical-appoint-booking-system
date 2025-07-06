package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.util.List;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;

public final class Doctor extends User {

    private Speciality speciality;
    private List<Schedule> scheduleAvailability;
}
