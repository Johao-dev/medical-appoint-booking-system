package zuzz.projects.medical_appointment_booking_system.domain.exception;

public class SlotNotAvailableException extends RuntimeException {

    public SlotNotAvailableException(String message) {
        super(message);
    }
}
