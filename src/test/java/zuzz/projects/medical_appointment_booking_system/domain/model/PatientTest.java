package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zuzz.projects.medical_appointment_booking_system.domain.model.appointments.Pending;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;
import zuzz.projects.medical_appointment_booking_system.shared.enums.AppointmentStateName;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DayOfWeek;

public class PatientTest {

    private final User doctorUser = new User.Builder()
        .id(1l)
        .fullName("Doctor")
        .build();

    private final User patientUser = new User.Builder()
        .id(2l)
        .fullName("Patient")
        .build();

    private Patient patient = new Patient();
    private Doctor doctor = new Doctor();

    @BeforeEach
    void setup() {
        doctor.setId(16l);
        doctor.setUser(doctorUser);
        doctor.setSpeciality(new Speciality(2l, "Speciality test"));

        patient.setUser(patientUser);
    }

    @Test
    void shouldReturnAnAppointmentWithPendingState() {
        Schedule schedule = new Schedule(
            DayOfWeek.THURSDAY,
            LocalTime.of(9,0),
            LocalTime.of(10, 30)
        );

        Appointment expected = new Appointment();
        expected.setDoctor(doctor);
        expected.setPatient(patient);
        expected.setSchedule(schedule);
        expected.setState(new Pending());
        expected.setReason("Reason example");

        Appointment appointmentRequest = patient.requestAppointment(doctor, schedule, "Reason example");

        assertEquals(expected, appointmentRequest);
        assertTrue(appointmentRequest.getState().getName() == AppointmentStateName.PENDING);
        assertTrue(appointmentRequest.getReason().equals(expected.getReason()));
    }
}
