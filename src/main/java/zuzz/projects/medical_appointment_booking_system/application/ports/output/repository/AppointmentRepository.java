package zuzz.projects.medical_appointment_booking_system.application.ports.output.repository;

import zuzz.projects.medical_appointment_booking_system.application.dto.AppointmentCancelledRequest;
import zuzz.projects.medical_appointment_booking_system.application.dto.AppointmentSearchParameters;
import zuzz.projects.medical_appointment_booking_system.application.dto.AppointmentUpdateStateRequest;
import zuzz.projects.medical_appointment_booking_system.domain.model.Appointment;
import zuzz.projects.medical_appointment_booking_system.shared.Page;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    Page<Appointment> findAllByFilters(AppointmentSearchParameters searchParameters);

    Page<Appointment> findAllByPatient(Long patientId, AppointmentSearchParameters searchParameters);

    Page<Appointment> findAllByDoctor(Long doctorId, AppointmentSearchParameters searchParameters);

    Page<Appointment> findAllByScheduleManager(Long scheduleManagerId, AppointmentSearchParameters searchParameters);

    Appointment updateState(AppointmentUpdateStateRequest request);

    Appointment cancel(AppointmentCancelledRequest request);
}
