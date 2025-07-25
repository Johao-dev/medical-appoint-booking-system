package zuzz.projects.medical_appointment_booking_system.application.dto;

import java.util.Optional;

public class AppointmentCancelledRequest {

    private final Long appointmentId;
    private Optional<String> reason = Optional.empty();

    public AppointmentCancelledRequest(Long appointmentId, String reason) {
        this.appointmentId = appointmentId;
        this.reason = Optional.of(reason);
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public Optional<String> getReason() {
        return reason;
    }
}
