package zuzz.projects.medical_appointment_booking_system.domain.model;

import zuzz.projects.medical_appointment_booking_system.domain.model.appointments.AppointmentState;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;

public class Appointment {

    private Long id;
    private String reason;
    private Doctor doctor;
    private Patient patient;
    private Schedule schedule;
    private AppointmentState state;
    private ScheduleManager scheduleManager;
}
