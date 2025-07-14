package zuzz.projects.medical_appointment_booking_system.domain.exception;

public class OverlappingSchedulesException extends RuntimeException {

    public OverlappingSchedulesException(String message) {
        super(message);
    }
}
