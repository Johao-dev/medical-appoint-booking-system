package zuzz.projects.medical_appointment_booking_system.application.ports.output;

import java.util.Optional;

import zuzz.projects.medical_appointment_booking_system.shared.Page;
import zuzz.projects.medical_appointment_booking_system.shared.PageRequest;

public interface CrudRepository<T, ID> {

    Page<T> findAll(PageRequest pageRequest);

    Optional<T> findById(ID id);

    T create(T t);

    T delete(ID id);
}
