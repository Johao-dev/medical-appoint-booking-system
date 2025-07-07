package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;
import java.util.List;

public final class ScheduleManager extends User {

    private List<Doctor> assignedDoctors;

    public ScheduleManager(Long id, Role role, String email, String password, String fullName, LocalDate birthDate) {
        super(id, role, email, password, fullName, birthDate);
    }

    public List<Doctor> getAssignedDoctors() {
        return assignedDoctors;
    }

    public void setAssignedDoctors(List<Doctor> assignedDoctors) {
        this.assignedDoctors = assignedDoctors;
    }
}
