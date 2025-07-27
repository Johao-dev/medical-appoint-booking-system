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
}