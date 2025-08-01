package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;

    @BeforeEach
    void setup() {
        user = new User.Builder()
            .id(167L)
            .fullName("John Doe")
            .email("john.doe@example.com")
            .password("password")
            .role(new Role(1L, "ROLE_PATIENT"))
            .birthDate(LocalDate.of(1990, 1, 1))
            .blocked(false)
            .build();
    }

    @Test
    void shouldUpdateUserEmail() {
        String newEmail = "john.doe@gmail.com";
        user.updateEmail(newEmail);

        assertEquals(newEmail, user.getEmail());
    }

    @Test
    void shouldThrowExceptionForInvalidEmailFormat() {
        String invalidEmailFormat = "john.doe@example";

        assertThrows(IllegalArgumentException.class, () -> {
            user.updateEmail(invalidEmailFormat);
        });
    }

    @Test
    void shouldThrowExceptionForNullOrEmptyEmail() {
        String newEmail = null;

        assertThrows(IllegalArgumentException.class, () -> {
            user.updateEmail(newEmail);
        });
    }

    @Test
    @Disabled(value = "The password must be hashed by the user, but I still don't know how to implement it.")
    void shouldChangeUserPassword() {

    }

    @Test
    void shouldReturnTrueIfUserIsBlocked() {
        user.blockAccount();
        assertTrue(user.isBlocked());
    }

    @Test
    void shouldReturnFalseIfUserIsNotBlocked() {
        assertFalse(user.isBlocked());
    }

    @Test
    void shouldUpdateUserFullName() {
        String newFullName = "John Doe Jr.";

        user.updateFullName(newFullName);

        assertEquals(newFullName, user.getFullName());
    }

    @Test
    void shouldUpdateUserBirthDate() {
        LocalDate newBirthDate = LocalDate.of(1990, 1, 2);

        user.updateBirthDate(newBirthDate);

        assertEquals(newBirthDate, user.getBirthDate());
    }

    @Test
    void shouldThrowExceptionForFutureBirthDate() {
        LocalDate futureBirthDate = LocalDate.of(2027, 7, 28);

        assertThrows(IllegalArgumentException.class, () -> {
            user.updateBirthDate(futureBirthDate);
        });
    }

    @Test
    void shouldReturnTrueIfUserHasSpecificRole() {
        assertTrue(user.hasRole(new Role(1L, "ROLE_PATIENT")));
    }

    @Test
    void shouldReturnFalseIfUserDoesNotHaveSpecificRole() {
        assertFalse(user.hasRole(new Role(10L, "ROLE_DOCTOR")));
    }
}
