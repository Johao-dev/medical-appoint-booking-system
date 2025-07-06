package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;

public sealed class User permits Patient {

    private Long id;
    private String fullName;
    private LocalDate birthDate;
    private String email;
    private String password;
}
