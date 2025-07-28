package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class User {

    private Long id;
    private Role role;
    private String email;
    private String password;
    private String fullName;
    private Boolean blocked;
    private LocalDate birthDate;

    private User(User.Builder builder) {
        this.id = builder.id;
        this.role = builder.role;
        this.email = builder.email;
        this.password = builder.password;
        this.fullName = builder.fullName;
        this.blocked = builder.blocked;
        this.birthDate = builder.birthDate;
    }

    public static class Builder {
        private Long id;
        private Role role;
        private String email;
        private String password;
        private String fullName;
        private Boolean blocked;
        private LocalDate birthDate;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder blocked(Boolean blocked) {
            this.blocked = blocked;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public void blockAccount() {
        this.blocked = true;
    }

    public void unblockAccount() {
        this.blocked = false;
    }

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
        return this.role.equals(role);
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean isDoctor() {
        return this.role.is("ROLE_DOCTOR");
    }

    public boolean isPatient() {
        return this.role.is("ROLE_PATIENT");
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}