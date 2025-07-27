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
}
