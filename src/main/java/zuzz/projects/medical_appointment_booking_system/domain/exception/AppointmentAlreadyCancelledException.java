package zuzz.projects.medical_appointment_booking_system.domain.exception;

public class AppointmentAlreadyCancelledException extends RuntimeException {

    public AppointmentAlreadyCancelledException(String message) {
        super(message);
    }
}
