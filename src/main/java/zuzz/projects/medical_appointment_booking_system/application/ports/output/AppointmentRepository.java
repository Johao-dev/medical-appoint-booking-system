package zuzz.projects.medical_appointment_booking_system.application.ports.output;

import java.util.List;
import java.util.Optional;

import zuzz.projects.medical_appointment_booking_system.domain.model.Appointment;
import zuzz.projects.medical_appointment_booking_system.domain.model.appointments.AppointmentState;

public interface AppointmentRepository {

    Appointment save(); // AppointmentRequest

    Optional<Appointment> findById(Long id);

    List<Appointment> findAll(Long id);

    List<Appointment> findAllByState(AppointmentState state);

    Appointment updateState(Long id, AppointmentState newState);
}
