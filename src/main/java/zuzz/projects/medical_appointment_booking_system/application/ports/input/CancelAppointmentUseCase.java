package zuzz.projects.medical_appointment_booking_system.application.ports.input;

import zuzz.projects.medical_appointment_booking_system.shared.commands.CancelAppointmentCommand;

public interface CancelAppointmentUseCase {

    void execute(CancelAppointmentCommand command);
}
