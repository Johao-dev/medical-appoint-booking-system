package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoctorTest {

    private User doctorUser;
    private Doctor doctor;

    @BeforeEach
    void setup() {
        doctorUser = new User.Builder()
            .fullName("Dr. John Doe")
            .build();

        doctor = Doctor.createNew(doctorUser, new Speciality(1L, "cardiology"));
    }

    @Test
    void shouldAssignNewSpeciality() {
        Speciality newSpeciality = new Speciality(2L, "neurology");
        doctor.assignSpeciality(newSpeciality);

        assertEquals(newSpeciality, doctor.getSpeciality());
    }

    @Test
    void shouldNotAssignNullSpeciality() {
        assertThrows(IllegalArgumentException.class, () -> {
            doctor.assignSpeciality(null);
        });
    }

    @Test
    void shouldUpdateAssociatedUserFields() {
        User newUser = new User.Builder()
            .fullName("Dr. zuzz")
            .build();

        doctor.updateUserDetails(newUser);
        assertEquals("Dr. zuzz", doctor.getDoctorFullName());
    }

    @Test
    void shouldReturnCorrectFullNameFromUser() {
        assertEquals("Dr. John Doe", doctor.getDoctorFullName());
    }
}
