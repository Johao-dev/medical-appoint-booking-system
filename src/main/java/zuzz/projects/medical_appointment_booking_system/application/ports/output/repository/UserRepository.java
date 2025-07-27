package zuzz.projects.medical_appointment_booking_system.application.ports.output.repository;

import java.util.Optional;

import zuzz.projects.medical_appointment_booking_system.domain.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User updateEmail(Long userId, String newEmail);

    User updatePassword(Long userId, String newPassword);

    User block(Long userId, Boolean blockStatus);
}
