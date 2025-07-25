package zuzz.projects.medical_appointment_booking_system.application.dto;

import java.util.Optional;

import zuzz.projects.medical_appointment_booking_system.shared.enums.AppointmentStateName;

public class AppointmentUpdateStateRequest {

    private Long appointmentId;
    private AppointmentStateName newState;
    private Long scheduleManagerId;
    private Optional<String> reason = Optional.empty();

    public AppointmentUpdateStateRequest(Long appointmentId, AppointmentStateName newState,
            Long scheduleManagerId, String reason) {
        this.appointmentId = appointmentId;
        this.newState = newState;
        this.scheduleManagerId = scheduleManagerId;
        this.reason = Optional.of(reason);
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public AppointmentStateName getNewState() {
        return newState;
    }

    public void setNewState(AppointmentStateName newState) {
        this.newState = newState;
    }

    public Long getScheduleManagerId() {
        return scheduleManagerId;
    }

    public void setScheduleManagerId(Long scheduleManagerId) {
        this.scheduleManagerId = scheduleManagerId;
    }

    public Optional<String> getReason() {
        return reason;
    }

    public void setReason(Optional<String> reason) {
        this.reason = reason;
    }
}
