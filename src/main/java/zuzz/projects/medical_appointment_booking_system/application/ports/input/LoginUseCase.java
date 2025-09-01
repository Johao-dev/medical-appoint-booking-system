package zuzz.projects.medical_appointment_booking_system.application.ports.input;

import zuzz.projects.medical_appointment_booking_system.shared.commands.LoginCommand;

public interface LoginUseCase {

    void execute(LoginCommand command);
}
