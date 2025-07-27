package zuzz.projects.medical_appointment_booking_system.domain.exception;

public class InvalidAppointmentStateException extends RuntimeException {

    public InvalidAppointmentStateException(String message) {
        super(message);
    }
}
