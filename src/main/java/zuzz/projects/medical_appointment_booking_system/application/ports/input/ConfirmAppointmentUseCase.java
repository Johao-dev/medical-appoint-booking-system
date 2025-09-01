package zuzz.projects.medical_appointment_booking_system.application.ports.input;

import zuzz.projects.medical_appointment_booking_system.shared.commands.ConfirmAppointmentCommand;

public interface ConfirmAppointmentUseCase {

    void execute(ConfirmAppointmentCommand command);
}
