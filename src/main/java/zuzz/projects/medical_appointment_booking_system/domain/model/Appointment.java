package zuzz.projects.medical_appointment_booking_system.domain.model;

import zuzz.projects.medical_appointment_booking_system.domain.exception.AppointmentAlreadyCancelledException;
import zuzz.projects.medical_appointment_booking_system.domain.exception.InvalidAppointmentStateException;
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
            AppointmentState state, String reason) {
        this.reason = reason;
        this.doctor = doctor;
        this.patient = patient;
        this.state = state;
        this.doctorAvailability = doctorAvailability;
    }

    public static Appointment scheduleNewAppointment(Patient patient, Doctor doctor,
            DoctorAvailability doctorAvailability, String reason) {
        return new Appointment(patient, doctor, doctorAvailability, AppointmentState.PENDING, reason);
    }

    public void confirm() {
        if (state != AppointmentState.PENDING) {
            throw new InvalidAppointmentStateException("Appointment can only be confirmed if it is PENDING");
        }
        state = AppointmentState.CONFIRMED;
    }

    public void reject(String rejectionReason) {
        if (state != AppointmentState.PENDING) {
            throw new InvalidAppointmentStateException("Appointment can only be rejected if it is PENDING");
        }
        if (rejectionReason == null || rejectionReason.trim().isEmpty()) {
            throw new IllegalArgumentException("Rejection reason cannot be empty");
        }
        state = AppointmentState.REJECTED;
        reason = rejectionReason;
    }

    public void cancel() {
        if (state == AppointmentState.CANCELLED || state == AppointmentState.COMPLETED ||
                state == AppointmentState.REJECTED || state == AppointmentState.EXPIRED) {
            throw new AppointmentAlreadyCancelledException(
                    "Appointment is already in a final state and cannot be cancelled");
        }
        state = AppointmentState.CANCELLED;
    }

    public void complete() {
        if (state != AppointmentState.CONFIRMED) {
            throw new InvalidAppointmentStateException("Appointment can only be completed if it is CONFIRMED");
        }
        state = AppointmentState.COMPLETED;
    }

    public void expire() {
        if (this.state == AppointmentState.PENDING || this.state == AppointmentState.CONFIRMED) {
            this.state = AppointmentState.EXPIRED;
        } else {
            throw new InvalidAppointmentStateException(
                    "Appointment cannot be expired from its current state: " + this.state);
        }
    }

    public boolean isPending() {
        return this.state == AppointmentState.PENDING;
    }

    public boolean isConfirmed() {
        return this.state == AppointmentState.CONFIRMED;
    }
}
