package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;

public sealed class User permits Patient, Doctor, ScheduleManager {

    private Long id;
    private Role role;
    private String email;
    private String password;
    private String fullName;
    private LocalDate birthDate;

    public User(Long id, Role role, String email, String password, String fullName, LocalDate birthDate) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }
}
