package zuzz.projects.medical_appointment_booking_system.domain.model;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Address;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PhoneNumber;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DocumentType;

public class Patient {

    private Long id;
    private User user;
    private Address address;
    private Character gender;
    private PhoneNumber phoneNumber;
    private String identificationDocumentNumber;
    private DocumentType identificationDocumentType;

    public void updateAddress(Address newAddress) {
        this.address = newAddress;
    }

    public void updatePhoneNumber(PhoneNumber newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void updateIdentification(DocumentType type, String number) {
        this.identificationDocumentType = type;
        this.identificationDocumentNumber = number;
    }

    public String getPatientFullName() {
        return user.getFullName();
    }
}