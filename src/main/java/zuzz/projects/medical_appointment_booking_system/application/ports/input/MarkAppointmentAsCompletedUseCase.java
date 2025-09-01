package zuzz.projects.medical_appointment_booking_system.application.ports.input;

import zuzz.projects.medical_appointment_booking_system.shared.commands.MarkAppointmentAsCompletedCommand;

public interface MarkAppointmentAsCompletedUseCase {

    void execute(MarkAppointmentAsCompletedCommand command);
}
