package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.util.ArrayList;
import java.util.List;

import zuzz.projects.medical_appointment_booking_system.domain.exception.DoctorAlreadyAssignedException;

@SuppressWarnings("unused")
public class ScheduleManager {

    private Long id;
    private User user;
    private List<Doctor> assignedDoctors;

    public static ScheduleManager createNew(User user) {
        ScheduleManager newScheduleManager = new ScheduleManager();
        newScheduleManager.id = 0L;
        newScheduleManager.user = user;
        newScheduleManager.assignedDoctors = new ArrayList<>();

        return newScheduleManager;
    }

    public static ScheduleManager createNewWithAssignedDoctors(User user, List<Doctor> assignedDoctors) {
        ScheduleManager newScheduleManager = new ScheduleManager();
        newScheduleManager.id = 0L;
        newScheduleManager.user = user;
        newScheduleManager.assignedDoctors = new ArrayList<>(assignedDoctors);

        return newScheduleManager;
    }

    private ScheduleManager() {

    }

    public void assignDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null");
        }
        if (assignedDoctors.contains(doctor)) {
            throw new DoctorAlreadyAssignedException("Doctor is already assigned to this schedule manager");
        }

        assignedDoctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        if (!assignedDoctors.contains(doctor)) {
            throw new IllegalArgumentException("Doctor is not assigned to this schedule manager");
        }

        assignedDoctors.remove(doctor);
    }

    public boolean managesDoctor(Doctor doctor) {
        return assignedDoctors.contains(doctor);
    }

    public void updateUserDetails(User newUserData) {
        this.user = newUserData;
    }

    public List<Doctor> getAssignedDoctors() {
        return assignedDoctors;
    }
}
