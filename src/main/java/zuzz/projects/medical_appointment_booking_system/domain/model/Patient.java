package zuzz.projects.medical_appointment_booking_system.domain.model;

import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Address;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PatientPersonalInformation;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PhoneNumber;
import zuzz.projects.medical_appointment_booking_system.shared.enums.AppointmentState;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DocumentType;

public class Patient {

    private Long id;
    private User user;
    private Address address;
    private Character gender;
    private PhoneNumber phoneNumber;
    private String identificationDocumentNumber;
    private DocumentType identificationDocumentType;

    public Appointment requestAppointment(Doctor doctor, DoctorAvailability doctorAvailability, String reason) {
        return Appointment.of(this, doctor, doctorAvailability, AppointmentState.PENDING, reason);
    }

    public void updatePersonalInformation(PatientPersonalInformation newPersonalInformation) {
        updateEmail(newPersonalInformation.getEmail());
        updatePassword(newPersonalInformation.getPassword());
        this.address = newPersonalInformation.getAddress();
        this.phoneNumber = newPersonalInformation.getPhoneNumber();
    }

    public void updatePassword(String newPassword) {
        this.user.updatePassword(newPassword);
    }

    public String getPassword() {
        return this.user.getPassword();
    }

    public void updateEmail(String newEmail) {
        this.user.updateEmail(newEmail);
    }

    public String getEmail() {
        return this.user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
