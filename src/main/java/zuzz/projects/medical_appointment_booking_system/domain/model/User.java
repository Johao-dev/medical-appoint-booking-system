package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Email;

public sealed class User permits Patient, Doctor, ScheduleManager {

    private Long id;
    private Role role;
    private Email email;
    private String password;
    private String fullName;
    private LocalDate birthDate;
}
