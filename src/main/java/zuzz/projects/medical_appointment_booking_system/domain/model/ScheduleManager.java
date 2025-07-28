package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.util.List;

@SuppressWarnings("unused")
public class ScheduleManager {

    private Long id;
    private User user;
    private List<Doctor> assignedDoctors;

    public void assignDoctor(Doctor doctor) {
        assignedDoctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        assignedDoctors.remove(doctor);
    }

    public boolean managesDoctor(Doctor doctor) {
        return assignedDoctors.contains(doctor);
    }

    public void updateUserDetails(User newUserData) {
        this.user = newUserData;
    }
}
