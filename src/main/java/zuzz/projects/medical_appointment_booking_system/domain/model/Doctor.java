package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.util.List;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;

public final class Doctor {

    private Long id;
    private User user;
    private Speciality speciality;
    private List<Schedule> scheduleAvailability;

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

    public void setScheduleAvailability(List<Schedule> scheduleAvailability) {
        this.scheduleAvailability = scheduleAvailability;
    }

    public void addScheduleAvailability(Schedule schedule) {
        scheduleAvailability.add(schedule);
    }

    public void removeScheduleAvailability(Schedule schedule) {
        scheduleAvailability.remove(schedule);
    }

    public boolean isAvailable(Schedule schedule) {
        return false;
    }

    public void listPendingAppointments() {

    }

    public void listCompletedAppointments() {

    }
}
