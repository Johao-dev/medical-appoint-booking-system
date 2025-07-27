package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;

public class User {

    private Long id;
    private Role role;
    private String email;
    private String password;
    private String fullName;
    private LocalDate birthDate;

    private User(Builder builder) {
        this.id = builder.id;
        this.role = builder.role;
        this.email = builder.email;
        this.password = builder.password;
        this.fullName = builder.fullName;
        this.birthDate = builder.birthDate;
    }

    public static class Builder {
        private Long id;
        private Role role;
        private String email;
        private String password;
        private String fullName;
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

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }
}
