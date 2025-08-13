package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zuzz.projects.medical_appointment_booking_system.domain.exception.DoctorAlreadyAssignedException;

public class ScheduleManagerTests {

    private ScheduleManager scheduleManager;

    @BeforeEach
    void setup() {
        scheduleManager = ScheduleManager.createNew(new User.Builder().build());
    }

    @Test
    void shouldAssignDoctorToManager() {
        Doctor doctor = Doctor.createNew(null, null);
        scheduleManager.assignDoctor(doctor);

        assertEquals(doctor, scheduleManager.getAssignedDoctors().get(0));
    }

    @Test
    void shouldThrowExceptionWhenAssigningDoctorTwice() {
        Doctor doctor = Doctor.createNew(null, null);
        scheduleManager.assignDoctor(doctor);

        assertThrows(DoctorAlreadyAssignedException.class, () -> {
            scheduleManager.assignDoctor(doctor);
        });
    }

    @Test
    void shouldThrowExceptionForNullDoctorAssignment() {
        assertThrows(IllegalArgumentException.class, () -> {
            scheduleManager.assignDoctor(null);
        });
    }

    @Test
    void shouldRemoveAssignedDoctor() {
        Doctor doctor = Doctor.createNew(null, null);
        scheduleManager.assignDoctor(doctor);

        assertEquals(1, scheduleManager.getAssignedDoctors().size());

        scheduleManager.removeDoctor(doctor);

        assertEquals(0, scheduleManager.getAssignedDoctors().size());
    }

    @Test
    void shouldThrowExceptionWhenRemovingNonExistentDoctor() {
        Doctor existingDoctor = Doctor.createNew(null, null);

        Doctor nonExistingDoctor = Doctor.createNew(
            new User.Builder()
                .fullName("John Doe")
                .build(),
            new Speciality(1L, "Cardiology"));

        scheduleManager.assignDoctor(existingDoctor);

        assertThrows(IllegalArgumentException.class, () -> {
            scheduleManager.removeDoctor(nonExistingDoctor);
        });
    }

    @Test
    void shouldReturnTrueIfDoctorIsManaged() {
        Doctor doctor = Doctor.createNew(null, null);
        scheduleManager.assignDoctor(doctor);

        assertTrue(scheduleManager.managesDoctor(doctor));
    }

    @Test
    void shouldReturnFalseIfDoctorIsNotManaged() {
        Doctor assignedDoctor = Doctor.createNew(null, null);

        Doctor nonAssignedDoctor = Doctor.createNew(
            new User.Builder()
                .fullName("John Doe")
                .build(),
            new Speciality(1L, "Cardiology"));

        scheduleManager.assignDoctor(assignedDoctor);

        assertFalse(scheduleManager.managesDoctor(nonAssignedDoctor));
    }
}
