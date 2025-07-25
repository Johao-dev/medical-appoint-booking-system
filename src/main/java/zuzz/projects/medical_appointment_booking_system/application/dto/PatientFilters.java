package zuzz.projects.medical_appointment_booking_system.application.dto;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PhoneNumber;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DocumentType;

public class PatientFilters {

    private String name;
    private String email;
    private Long addressId;
    private Character gender;
    private PhoneNumber phoneNumber;
    private String identificationDocumentNumber;
    private DocumentType identificationDocumentType;

    private PatientFilters(PatientFilters.Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.addressId = builder.addressId;
        this.gender = builder.gender;
        this.phoneNumber = builder.phoneNumber;
        this.identificationDocumentNumber = builder.identificationDocumentNumber;
        this.identificationDocumentType = builder.identificationDocumentType;
    }

    public static class Builder {
        private String name;
        private String email;
        private Long addressId;
        private Character gender;
        private PhoneNumber phoneNumber;
        private String identificationDocumentNumber;
        private DocumentType identificationDocumentType;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder addressId(Long addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder gender(Character gender) {
            this.gender = gender;
            return this;
        }

        public Builder phoneNumber(PhoneNumber phoneNumber) {
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

        public PatientFilters build() {
            return new PatientFilters(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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