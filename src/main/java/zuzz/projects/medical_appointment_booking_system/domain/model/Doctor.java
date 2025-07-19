package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.util.ArrayList;
import java.util.List;

import zuzz.projects.medical_appointment_booking_system.domain.exception.OverlappingSchedulesException;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;

public class Doctor {

    private Long id;
    private User user;
    private Speciality speciality;
    private List<Schedule> scheduleAvailability;

    public Doctor() {
        scheduleAvailability = new ArrayList<>();
    }

    public void addScheduleAvailability(Schedule newSchedule) {
        if (newSchedule == null)
            throw new NullPointerException("Schedule is null");

        for (Schedule existingSchedule : scheduleAvailability) {
            checkOverlap(newSchedule, existingSchedule);
        }

        scheduleAvailability.add(newSchedule);
    }

    private void checkOverlap(Schedule newSchedule, Schedule existingSchedule) {
        if (newSchedule.overlapsWith(existingSchedule))
            throw new OverlappingSchedulesException("The schedule could not be assigned");
    }

    public void removeScheduleAvailability(Schedule schedule) {
        if (schedule == null)
            throw new NullPointerException("Schedule is null");
        scheduleAvailability.remove(schedule);
    }

    public boolean isAvailable(Schedule schedule) {
        boolean available = true;
        for (Schedule each : scheduleAvailability) {
            if (each.overlapsWith(schedule)) {
                available = false;
            }
        }
        return available;
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Schedule> getScheduleAvailability() {
        return scheduleAvailability;
    }
}
