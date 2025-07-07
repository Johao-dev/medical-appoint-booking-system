package zuzz.projects.medical_appointment_booking_system.domain.model;

import java.time.LocalDate;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Address;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PhoneNumber;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DocumentType;

public final class Patient extends User {

    private Address address;
    private Character gender;
    private PhoneNumber phoneNumber;
    private String identificationDocumentNumber;
    private DocumentType identificationDocumentType;

    public Patient(Long id, Role role, String email, String password, String fullName, LocalDate birthDate) {
        super(id, role, email, password, fullName, birthDate);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentificationDocumentNumber() {
        return identificationDocumentNumber;
    }

    public void setIdentificationDocumentNumber(String identificationDocumentNumber) {
        this.identificationDocumentNumber = identificationDocumentNumber;
    }

    public DocumentType getIdentificationDocumentType() {
        return identificationDocumentType;
    }

    public void setIdentificationDocumentType(DocumentType identificationDocumentType) {
        this.identificationDocumentType = identificationDocumentType;
    }
}
