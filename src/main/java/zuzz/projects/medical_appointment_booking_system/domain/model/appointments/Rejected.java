package zuzz.projects.medical_appointment_booking_system.domain.model.appointments;

import zuzz.projects.medical_appointment_booking_system.shared.enums.AppointmentStateName;

public class Rejected implements AppointmentState {

    @Override
    public AppointmentStateName getName() {
        return AppointmentStateName.REJECTED;
    }
}
