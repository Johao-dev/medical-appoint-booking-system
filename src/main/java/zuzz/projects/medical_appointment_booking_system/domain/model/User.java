package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;

public class User {

    private Long id;
    private Role role;
    private String email;
    private String password;
    private String fullName;
    private LocalDate birthDate;

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void updateFullName(String newFullName) {
        this.fullName = newFullName;
    }

    public void updateBirthDate(LocalDate newBirthDate) {
        this.birthDate = newBirthDate;
    }

    public boolean hasRole(Role role) {
        return false;
    }

    public boolean isDoctor() {
        return this.role.is("ROLE_DOCTOR");
    }

    public boolean isPatient() {
        return this.role.is("ROLE_PATIENT");
    }
}
