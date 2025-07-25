package zuzz.projects.medical_appointment_booking_system.application.ports.output;

import java.util.Optional;

import zuzz.projects.medical_appointment_booking_system.domain.model.Doctor;
import zuzz.projects.medical_appointment_booking_system.shared.Page;
import zuzz.projects.medical_appointment_booking_system.shared.PageRequest;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    Optional<Doctor> findByUserId(Long userId);

    Page<Doctor> findALlBySpeciality(Long specialityId, PageRequest pageRequest);
}
