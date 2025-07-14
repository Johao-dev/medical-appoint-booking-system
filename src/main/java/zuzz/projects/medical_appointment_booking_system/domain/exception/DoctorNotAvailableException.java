package zuzz.projects.medical_appointment_booking_system.domain.exception;

public class DoctorNotAvailableException extends RuntimeException {

    public DoctorNotAvailableException(String message) {
        super(message);
    }
}
