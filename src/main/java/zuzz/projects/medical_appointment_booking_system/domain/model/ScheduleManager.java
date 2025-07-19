package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {

    private Long id;
    private User user;
    private List<Doctor> assignedDoctors;

    public ScheduleManager() {
        this.assignedDoctors = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Doctor> getAssignedDoctors() {
        return assignedDoctors;
    }

    public void setAssignedDoctors(List<Doctor> assignedDoctors) {
        this.assignedDoctors = assignedDoctors;
    }
}
