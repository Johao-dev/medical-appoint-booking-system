package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SpecialityTest {

    @Test
    void shouldReturnTrueWhenNameMatches() {
        Speciality speciality = new Speciality(1L, "Cardiology");

        assertTrue(speciality.is("Cardiology"));
    }

    @Test
    void shouldReturnFalseWhenNameDoesNotMatch() {
        Speciality speciality = new Speciality(1L, "Cardiology");

        assertFalse(speciality.is("Neurology"));
    }
}
