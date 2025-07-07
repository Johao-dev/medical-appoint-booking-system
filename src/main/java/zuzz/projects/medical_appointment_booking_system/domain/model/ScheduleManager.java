package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.util.List;

public final class ScheduleManager extends User {

    private List<Doctor> assignedDoctors;

    public List<Doctor> getAssignedDoctors() {
        return assignedDoctors;
    }

    public void setAssignedDoctors(List<Doctor> assignedDoctors) {
        this.assignedDoctors = assignedDoctors;
    }
}
