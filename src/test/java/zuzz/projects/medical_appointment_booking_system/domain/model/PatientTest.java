package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Address;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PatientPersonalInformation;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PhoneNumber;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;
import zuzz.projects.medical_appointment_booking_system.shared.enums.AppointmentState;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DayOfWeek;

public class PatientTest {

    private final User doctorUser = new User.Builder()
        .id(1l)
        .fullName("Doctor")
        .build();

    private final User patientUser = new User.Builder()
        .id(2l)
        .fullName("Patient")
        .email("patientTest@example.com")
        .password("patientPassword")
        .build();

    private Patient patient = new Patient();
    private Doctor doctor = new Doctor();

    @BeforeEach
    void setup() {
        doctor.setId(16l);
        doctor.setUser(doctorUser);
        doctor.setSpeciality(new Speciality(2l, "Speciality test"));

        patient.setUser(patientUser);
        patient.setAddress(new Address.Builder()
            .street("Street 123")
            .district("District")
            .province("Province")
            .department("Department")
            .build()
        );
        patient.setPhoneNumber(new PhoneNumber("+51", "999999999"));
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
        expected.setState(AppointmentState.PENDING);
        expected.setReason("Reason example");

        Appointment appointmentRequest = patient.requestAppointment(doctor, schedule, "Reason example");

        assertEquals(expected, appointmentRequest);
        assertTrue(appointmentRequest.getState() == AppointmentState.PENDING);
        assertTrue(appointmentRequest.getReason().equals(expected.getReason()));
    }

    @Test
    void shouldChangeHisPersonalInformation() {
        PatientPersonalInformation newPersonalInformation = new PatientPersonalInformation();
        newPersonalInformation.setAddress(new Address.Builder()
            .district("District 2")
            .province("Province 2")
            .build()
        );
        newPersonalInformation.setPhoneNumber(new PhoneNumber("+51", "999777888"));
        newPersonalInformation.setEmail("newPatientEmail@example.com");
        newPersonalInformation.setPassword("newPassword");

        patient.updatePersonalInformation(newPersonalInformation);

        assertEquals("newPatientEmail@example.com", patient.getEmail());
        assertEquals("newPassword", patient.getPassword());
        assertEquals(new PhoneNumber("+51", "999777888"), patient.getPhoneNumber());
        assertEquals(new Address.Builder()
            .district("District 2")
            .province("Province 2")
            .build(), patient.getAddress());
    }

    @Test
    void shouldUpdateHisPassword() {
        String newPassword = "newPatientPassword";

        patient.updatePassword(newPassword);

        assertEquals(newPassword, patient.getPassword());
    }
}
