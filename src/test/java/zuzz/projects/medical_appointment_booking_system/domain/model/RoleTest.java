package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    void shouldReturnTrueWhenNameMatches() {
        Role role = new Role(1L, "ROLE_DOCTOR");

        assertTrue(role.is("ROLE_DOCTOR"));
    }

    @Test
    void shouldReturnFalseWhenNameDoesNotMatch() {
        Role role = new Role(1L, "ROLE_DOCTOR");

        assertFalse(role.is("ROLE_PATIENT"));
    }
}