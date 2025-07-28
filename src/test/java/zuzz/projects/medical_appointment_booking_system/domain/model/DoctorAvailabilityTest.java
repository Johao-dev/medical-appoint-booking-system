package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zuzz.projects.medical_appointment_booking_system.domain.exception.SlotNotAvailableException;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.AvailabilityPeriod;

public class DoctorAvailabilityTest {

    private Doctor doctor;
    private AvailabilityPeriod period;

    @BeforeEach
    void setup() {
        doctor = Doctor.createNew(null, null);
        period = new AvailabilityPeriod(
            LocalDate.of(2025, 7, 28),
            LocalTime.of(9, 0),
            LocalTime.of(12, 0));
    }

    @Test
    void shouldCreateAvailabilityWithCalculatedSlots() {
        DoctorAvailability.create(doctor, period, 30, 6, 6);
    }

    @Test
    void shouldThrowExceptionForInvalidTimeRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            AvailabilityPeriod period = new AvailabilityPeriod(
            LocalDate.of(2025, 7, 28),
            LocalTime.of(12, 0),
            LocalTime.of(9, 0));

            DoctorAvailability.create(doctor, period, 30, 6, 6);
        });
    }

    @Test
    void shouldThrowExceptionForZeroTotalSlots() {
        assertThrows(IllegalArgumentException.class, () -> {
            DoctorAvailability.create(doctor, period, 30, 0, 6);
        });
    }

    @Test
    void shouldDecrementAvailableSlotWhenPossible() {
        DoctorAvailability doctorAvailability = DoctorAvailability.create(
            doctor, period, 30, 6, 6);

        doctorAvailability.decrementSlot();

        assertEquals(5, doctorAvailability.getAvailableSlots());
    }

    @Test
    void shouldThrowExceptionWhenNoSlotsAreAvailable() {
        DoctorAvailability doctorAvailability = DoctorAvailability.create(
            doctor, period, 30, 6, 0);

        assertThrows(SlotNotAvailableException.class, () -> {
            doctorAvailability.decrementSlot();
        });
    }

    @Test
    void shouldIncrementAvailableSlotWhenPossible() {
        DoctorAvailability doctorAvailability = DoctorAvailability.create(
            doctor, period, 30, 6, 5);

        doctorAvailability.incrementSlot();

        assertEquals(6, doctorAvailability.getAvailableSlots());
    }

    @Test
    void shouldThrowExceptionWhenSlotsAreFull() {
        DoctorAvailability doctorAvailability = DoctorAvailability.create(
            doctor, period, 30, 6, 6);

        assertThrows(SlotNotAvailableException.class, () -> {
            doctorAvailability.incrementSlot();
        });
    }

    @Test
    void shouldActivateAvailability() {
        DoctorAvailability doctorAvailability = DoctorAvailability.create(
            doctor, period, 30, 6, 6);

        assertTrue(doctorAvailability.isActive());
    }

    @Test
    void shouldDeactivateAvailability() {
        DoctorAvailability doctorAvailability = DoctorAvailability.create(
            doctor, period, 30, 6, 6);
        doctorAvailability.deactivate();

        assertFalse(doctorAvailability.isActive());
    }

    @Test
    void shouldReturnTrueWhenActiveAndSlotsAvailable() {
        DoctorAvailability doctorAvailability = DoctorAvailability.create(
            doctor, period, 30, 6, 6);

        assertTrue(doctorAvailability.isAvailable());
    }

    @Test
    void shouldReturnFalseWhenNotActive() {
        DoctorAvailability doctorAvailability = DoctorAvailability.create(
            doctor, period, 30, 6, 6);
        doctorAvailability.deactivate();

        assertFalse(doctorAvailability.isAvailable());
    }

    @Test
    void shouldReturnFalseWhenNoSlotsAvailable() {
        DoctorAvailability doctorAvailability = DoctorAvailability.create(
            doctor, period, 30, 6, 0);

        assertFalse(doctorAvailability.isAvailable());
    }
}