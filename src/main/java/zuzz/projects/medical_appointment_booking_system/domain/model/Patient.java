package zuzz.projects.medical_appointment_booking_system.domain.model;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Address;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PhoneNumber;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DocumentType;

@SuppressWarnings("unused")
public class Patient {

    private Long id;
    private User user;
    private Address address;
    private Character gender;
    private PhoneNumber phoneNumber;
    private String identificationDocumentNumber;
    private DocumentType identificationDocumentType;

    public Patient(Patient.Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.address = builder.address;
        this.gender = builder.gender;
        this.phoneNumber = builder.phoneNumber;
        this.identificationDocumentNumber = builder.identificationDocumentNumber;
        this.identificationDocumentType = builder.identificationDocumentType;
    }

    public static class Builder {
        private Long id;
        private User user;
        private Address address;
        private Character gender;
        private PhoneNumber phoneNumber;
        private String identificationDocumentNumber;
        private DocumentType identificationDocumentType;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder gender(Character gender) {
            this.gender = gender;
            return this;
        }

        public Builder phoneNumber(PhoneNumber phoneNumber) {
            if (!phoneNumber.isValid()) {
                throw new IllegalArgumentException("Invalid phone number");
            }

            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder identificationDocumentNumber(String identificationDocumentNumber) {
            this.identificationDocumentNumber = identificationDocumentNumber;
            return this;
        }

        public Builder identificationDocumentType(DocumentType identificationDocumentType) {
            this.identificationDocumentType = identificationDocumentType;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }
    }

    public void updateAddress(Address newAddress) {
        if (newAddress == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        
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

    public Address getAddress() {
        return address;
    }

    public Character getGender() {
        return gender;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public String getIdentificationDocumentNumber() {
        return identificationDocumentNumber;
    }

    public DocumentType getIdentificationDocumentType() {
        return identificationDocumentType;
    }
}