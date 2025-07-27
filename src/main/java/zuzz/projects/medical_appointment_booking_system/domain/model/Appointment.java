package zuzz.projects.medical_appointment_booking_system.domain.model;

import zuzz.projects.medical_appointment_booking_system.shared.enums.AppointmentState;

public class Appointment {

    private Long id;
    private String reason;
    private Doctor doctor;
    private Patient patient;
    private AppointmentState state;
    private ScheduleManager scheduleManager;
    private DoctorAvailability doctorAvailability;

    private Appointment(Patient patient, Doctor doctor, DoctorAvailability doctorAvailability,
        AppointmentState initialState, String reason) {
        this.reason = reason;
        this.doctor = doctor;
        this.patient = patient;
        this.state = initialState;
        this.doctorAvailability = doctorAvailability;
    }

    public static Appointment scheduleNewAppointment(Patient patient, Doctor doctor,
        DoctorAvailability doctorAvailability, String reason) {
        return new Appointment(patient, doctor, doctorAvailability, AppointmentState.PENDING, reason);
    }

    public void confirm() {
        // TODO: It can only be confirmed if it is in PENDING.
    }

    public void reject() {
        // TODO: It can only be rejected if it is in PENDING.
    }

    public void cancel() {
        // TODO: It can only be cancelled if it is in PENDING or CONFIRMED.
    }

    public void complete() {
        // TODO: It can only be completed if it is in CONFIRMED.
    }

    public void expire() {
        // TODO: It can only expire if it is PENDING or CONFIRMED (and the date has
        // passed)
    }

    public boolean isPending() {
        return this.state == AppointmentState.PENDING;
    }

    public boolean isConfirmed() {
        return this.state == AppointmentState.CONFIRMED;
    }
}
