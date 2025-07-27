package zuzz.projects.medical_appointment_booking_system.application.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import zuzz.projects.medical_appointment_booking_system.shared.enums.AppointmentState;

public class AppointmentFilters {

    private AppointmentState state;
    private LocalDate appointmentDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long specialityId;

    private AppointmentFilters(AppointmentFilters.Builder builder) {
        this.state = builder.state;
        this.appointmentDate = builder.appointmentDate;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.specialityId = builder.specialityId;
    }

    public static class Builder {
        private AppointmentState state;
        private LocalDate appointmentDate;
        private LocalTime startTime;
        private LocalTime endTime;
        private Long specialityId;

        public Builder state(AppointmentState state) {
            this.state = state;
            return this;
        }

        public Builder appointmentDate(LocalDate appointmentDate) {
            this.appointmentDate = appointmentDate;
            return this;
        }

        public Builder startTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder specialityId(Long specialityId) {
            this.specialityId = specialityId;
            return this;
        }

        public AppointmentFilters build() {
            return new AppointmentFilters(this);
        }
    }

    public AppointmentState getState() {
        return state;
    }

    public void setState(AppointmentState state) {
        this.state = state;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }
}