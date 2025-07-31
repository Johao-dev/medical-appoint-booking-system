package zuzz.projects.medical_appointment_booking_system.domain.exception;

public class DoctorAlreadyAssignedException extends RuntimeException {

    public DoctorAlreadyAssignedException(String message) {
        super(message);
    }
}
