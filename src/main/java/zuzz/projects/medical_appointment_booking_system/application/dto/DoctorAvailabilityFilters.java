package zuzz.projects.medical_appointment_booking_system.application.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DoctorAvailabilityFilters {

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean active;
    private Integer minAvailableSlots;

    private DoctorAvailabilityFilters(DoctorAvailabilityFilters.Builder builder) {
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.active = builder.active;
        this.minAvailableSlots = builder.minAvailableSlots;
    }

    public static class Builder {
        private LocalDate startDate;
        private LocalDate endDate;
        private LocalTime startTime;
        private LocalTime endTime;
        private Boolean active;
        private Integer minAvailableSlots;

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
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

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Builder minAvailableSlots(Integer minAvailableSlots) {
            this.minAvailableSlots = minAvailableSlots;
            return this;
        }

        public DoctorAvailabilityFilters build() {
            return new DoctorAvailabilityFilters(this);
        }
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getMinAvailableSlots() {
        return minAvailableSlots;
    }

    public void setMinAvailableSlots(Integer minAvailableSlots) {
        this.minAvailableSlots = minAvailableSlots;
    }
}