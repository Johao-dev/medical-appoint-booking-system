package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

import zuzz.projects.medical_appointment_booking_system.domain.exception.SlotNotAvailableException;

public class DoctorAvailability {

    private Long id;
    private Doctor doctor;

    private LocalDate availabilityDate;
    private LocalTime startTime;
    private LocalTime endTime;

    private Integer durationSlotsInMinutes;
    private Integer totalSlots;
    private Integer availableSlots;

    private Boolean active;

    public void decrementSlot() {
        if (availableSlots == 0)
            throw new SlotNotAvailableException("Slot is not available");

        availableSlots--;
    }

    public void incrementSlot() {
        if (availableSlots == totalSlots)
            throw new SlotNotAvailableException("Slot is full");

        availableSlots++;
    }

    public boolean isAvailable() {
        return active && availableSlots > 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(LocalDate availabilityDate) {
        this.availabilityDate = availabilityDate;
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

    public Integer getDurationSlotsInMinutes() {
        return durationSlotsInMinutes;
    }

    public void setDurationSlotsInMinutes(Integer durationSlotsInMinutes) {
        this.durationSlotsInMinutes = durationSlotsInMinutes;
    }

    public Integer getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(Integer totalSlots) {
        this.totalSlots = totalSlots;
    }

    public Integer getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(Integer availableSlots) {
        this.availableSlots = availableSlots;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean isActive) {
        this.active = isActive;
    }
}
