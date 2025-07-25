package zuzz.projects.medical_appointment_booking_system.application.ports.output;

import zuzz.projects.medical_appointment_booking_system.application.dto.DoctorAvailabilitySearchParameters;
import zuzz.projects.medical_appointment_booking_system.domain.model.DoctorAvailability;
import zuzz.projects.medical_appointment_booking_system.shared.Page;

public interface DoctorAvailabilityRepository extends CrudRepository<DoctorAvailability, Long> {

    Page<DoctorAvailability> findAllByDoctor(Long doctorId, DoctorAvailabilitySearchParameters searchParameters);

    DoctorAvailability decrementAvailableSlots(Long availabilityId);
    
    DoctorAvailability incrementAvailableSlots(Long availabilityId);
}
