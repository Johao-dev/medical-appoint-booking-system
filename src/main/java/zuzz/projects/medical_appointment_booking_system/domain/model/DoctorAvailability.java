package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

import zuzz.projects.medical_appointment_booking_system.domain.exception.SlotNotAvailableException;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.AvailabilityPeriod;

@SuppressWarnings("unused")
public class DoctorAvailability {

    private Long id;
    private Doctor doctor;
    private AvailabilityPeriod period;
    private Integer durationSlotsInMinutes;
    private Integer totalSlots;
    private Integer availableSlots;
    private Boolean active;

    public static DoctorAvailability create(
        Doctor doctor, AvailabilityPeriod period, Integer durationSlotsInMinutes,
        Integer totalSlots, Integer availableSlots
    ) {
        DoctorAvailability doctorAvailability = new DoctorAvailability();
        doctorAvailability.doctor = doctor;
        doctorAvailability.period = period;
        doctorAvailability.durationSlotsInMinutes = durationSlotsInMinutes;
        doctorAvailability.totalSlots = totalSlots;
        doctorAvailability.availableSlots = availableSlots;
        doctorAvailability.active = true;

        return doctorAvailability;
    }

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

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public boolean isAvailable() {
        return active && availableSlots > 0;
    }
}