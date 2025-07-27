package zuzz.projects.medical_appointment_booking_system.application.ports.output.repository;

import java.util.Optional;

import zuzz.projects.medical_appointment_booking_system.application.dto.PatientSearchParameters;
import zuzz.projects.medical_appointment_booking_system.domain.model.Patient;
import zuzz.projects.medical_appointment_booking_system.shared.Page;

public interface PatientRepository extends CrudRepository<Patient, Long> {

    Optional<Patient> findByUserId(Long userId);

    Page<Patient> findAllByFilters(PatientSearchParameters searchParameters);
}
