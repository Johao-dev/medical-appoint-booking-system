package zuzz.projects.medical_appointment_booking_system.application.ports.input;

import zuzz.projects.medical_appointment_booking_system.shared.commands.RequestAppointmentCommand;

public interface RequestAppointmentUseCase {

    void execute(RequestAppointmentCommand command);
}
