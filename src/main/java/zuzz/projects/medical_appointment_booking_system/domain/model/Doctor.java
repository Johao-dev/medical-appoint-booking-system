package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.util.List;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;

public final class Doctor extends User {

    private Speciality speciality;
    private List<Schedule> scheduleAvailability;

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
}
