package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.util.List;

import zuzz.projects.medical_appointment_booking_system.domain.model.appointments.AppointmentState;

public final class ScheduleManager {

    private Long id;
    private User user;
    private List<Doctor> assignedDoctors;

    public void confirmAppointment(Appointment appointment) {
        // TODO: A ScheduleManager can confirm an appointment
    }

    public void rejectAppointment(Appointment appointment) {
        // TODO: A ScheduleManager can reject an appointment
    }

    public void viewAppointmentDetails(Appointment appointment) {
        // TODO: A ScheduleManager can view an appointment and its details
    }

    public List<Appointment> ViewPendingAppointments() {
        // TODO: A ScheduleManager can view all pending appointments
        return null;
    }

    public List<Appointment> listAppointmentsByState(AppointmentState state) {
        // TODO: A ScheduleManager can view all appointments (by state)
        return null;
    }

    public void updateDoctorAvailability() {
        // TODO: A ScheduleManager can change or update the schedule availability of a doctor
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
