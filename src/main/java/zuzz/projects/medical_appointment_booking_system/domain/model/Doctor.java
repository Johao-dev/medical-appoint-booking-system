package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;
import java.util.List;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;

public final class Doctor extends User {

    private Speciality speciality;
    private List<Schedule> scheduleAvailability;

    public Doctor(Long id, Role role, String email, String password, String fullName, LocalDate birthDate) {
        super(id, role, email, password, fullName, birthDate);
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
}
