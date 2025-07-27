package zuzz.projects.medical_appointment_booking_system.application.ports.output.repository;

import java.util.Optional;

import zuzz.projects.medical_appointment_booking_system.domain.model.ScheduleManager;

public interface ScheduleManagerRepository extends CrudRepository<ScheduleManager, Long> {

    Optional<ScheduleManager> findByUserId(Long userId);
}
