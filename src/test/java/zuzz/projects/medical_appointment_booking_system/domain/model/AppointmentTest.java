package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zuzz.projects.medical_appointment_booking_system.domain.exception.AppointmentAlreadyCancelledException;
import zuzz.projects.medical_appointment_booking_system.domain.exception.InvalidAppointmentStateException;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.AvailabilityPeriod;

public class AppointmentTest {

    private Doctor doctor;
    private Patient patient;
    private DoctorAvailability doctorAvailability;

    @BeforeEach
    void init() {
        doctor = Doctor.createNew(null, null);
        patient = new Patient();

        doctorAvailability = DoctorAvailability.create(
            doctor,
            new AvailabilityPeriod(
                LocalDate.of(2025, 7, 28),
                LocalTime.of(9, 0),
                LocalTime.of(12, 0)
            ),
            30, 6, 0);
    }

    @Test
    void shouldCreatePendingAppointmentWithValidParameters() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");

        assertTrue(appointment.isPending());
    }

    @Test
    void shouldThrowExceptionWhenCreatingWithNullParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            Appointment.scheduleNewAppointment(
                patient, null, null, "appointment reason");
        });
    }

    @Test
    void shouldThrowExceptionWhenCreatingWithUnavailableDoctorAvailability() {
        assertThrows(InvalidAppointmentStateException.class, () -> {
            Appointment.scheduleNewAppointment(
                patient, doctor, doctorAvailability, "appointment reason");
        });
    }

    @Test
    void shouldConfirmPendingAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");

        appointment.confirm();

        assertTrue(appointment.isConfirmed());
    }

    @Test
    void shouldThrowExceptionWhenConfirmingNonPendingAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");
        appointment.cancel();

        assertThrows(InvalidAppointmentStateException.class, () -> {
            appointment.confirm();
        });
    }

    @Test
    void shouldRejectPendingAppointmentWithReason() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");

        appointment.reject("slot occupied");

        assertTrue(appointment.isRejected());
    }

    @Test
    void shouldThrowExceptionWhenRejectingNonPendingAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");
        appointment.confirm();

        assertThrows(InvalidAppointmentStateException.class, () -> {
            appointment.reject("rejection reason");
        });
    }

    @Test
    void shouldThrowExceptionWhenRejectingWithEmptyReason() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.reject("");
        });
    }

    @Test
    void shouldCancelPendingAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");
        
        appointment.cancel();

        assertTrue(appointment.isCancelled());
    }

    @Test
    void shouldCancelConfirmedAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");
        appointment.confirm();

        appointment.cancel();

        assertTrue(appointment.isCancelled());
    }

    @Test
    void shouldThrowExceptionWhenCancellingFinalStateAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");
        appointment.reject("rejection reason");

        assertThrows(AppointmentAlreadyCancelledException.class, () -> {
            appointment.cancel();
        });
    }

    @Test
    void shouldCompleteConfirmedAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");
        appointment.confirm();

        appointment.complete();

        assertTrue(appointment.isCompleted());
    }

    @Test
    void shouldThrowExceptionWhenCompletingNonConfirmedAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");
        
        assertThrows(InvalidAppointmentStateException.class, () -> {
            appointment.complete();
        });
    }

    @Test
    void shouldExpirePendingAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");
        
        appointment.expire();

        assertTrue(appointment.isExpired());
    }

    @Test
    void shouldExpireConfirmedAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");
        appointment.confirm();

        appointment.expire();

        assertTrue(appointment.isExpired());
    }

    @Test
    void shouldNotExpireAlreadyFinalizedAppointment() {
        doctorAvailability.incrementSlot();
        Appointment appointment = Appointment.scheduleNewAppointment(
            patient, doctor, doctorAvailability, "appointment reason");
        appointment.confirm();
        appointment.complete();

        assertThrows(InvalidAppointmentStateException.class, () -> {
            appointment.expire();
        });
    }
}
