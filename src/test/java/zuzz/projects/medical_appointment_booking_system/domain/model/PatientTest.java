package zuzz.projects.medical_appointment_booking_system.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Address;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PhoneNumber;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DocumentType;

public class PatientTest {

    private User patientUser;
    private Patient patient;

    @BeforeEach
    void setup() {
        patientUser = new User.Builder()
            .fullName("John Doe")
            .build();

        patient = new Patient.Builder()
            .user(patientUser)
            .address(new Address.Builder()
                .street("street 1")
                .district("District 1")
                .build())
            .gender('M')
            .phoneNumber(new PhoneNumber("+51", "987654321"))
            .identificationDocumentType(DocumentType.DNI)
            .identificationDocumentNumber("74747474")
            .build();
    }
    
    @Test
    void shouldUpdatePatientAddress() {
        Address newPatientAddress = new Address.Builder()
            .street("street 2")
            .district("District 2")
            .build();

        patient.updateAddress(newPatientAddress);

        assertEquals(newPatientAddress, patient.getAddress());
    }

    @Test
    void shouldThrowExceptionForNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            patient.updateAddress(null);
        });
    }

    @Test
    void shouldUpdatePatientPhoneNumber() {
        PhoneNumber newPatientPhoneNumber = new PhoneNumber("+51", "987654322");

        patient.updatePhoneNumber(newPatientPhoneNumber);

        assertEquals(newPatientPhoneNumber, patient.getPhoneNumber());
    }

    @Test
    void shouldUpdateIdentificationDetails() {
        DocumentType newPatientIdentificationDocumentType = DocumentType.CE;
        String newPatientIdentificationDocumentNumber = "777777777";

        patient.updateIdentification(newPatientIdentificationDocumentType, newPatientIdentificationDocumentNumber);

        assertEquals(newPatientIdentificationDocumentType, patient.getIdentificationDocumentType());
        assertEquals(newPatientIdentificationDocumentNumber, patient.getIdentificationDocumentNumber());
    }

    @Test
    void shouldReturnCorrectPatientFullName() {
        assertEquals("John Doe", patient.getPatientFullName());
    }
}