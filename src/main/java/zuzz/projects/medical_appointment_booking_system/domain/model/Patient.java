package zuzz.projects.medical_appointment_booking_system.domain.model;

import zuzz.projects.medical_appointment_booking_system.domain.exception.DoctorNotAvailableException;
import zuzz.projects.medical_appointment_booking_system.domain.model.appointments.Pending;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Address;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PatientPersonalInformation;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.PhoneNumber;
import zuzz.projects.medical_appointment_booking_system.domain.valueobject.Schedule;
import zuzz.projects.medical_appointment_booking_system.shared.enums.DocumentType;

public final class Patient {

    private Long id;
    private User user;
    private Address address;
    private Character gender;
    private PhoneNumber phoneNumber;
    private String identificationDocumentNumber;
    private DocumentType identificationDocumentType;

    public Appointment requestAppointment(Doctor doctor, Schedule schedule, String reason) {
        if (!doctor.isAvailable(schedule))
            throw new DoctorNotAvailableException("The doctor is not available for that schedule");

        return Appointment.of(this, doctor, schedule, new Pending(), reason);
    }

    public void cancelAppointment(Appointment appointment) {
        // TODO: A patient can canceled an appointment
    }

    public void viewAllAppointments() {
        // TODO: A patient can view all his appointments
    }

    public void updatePersonalInformation(PatientPersonalInformation newPersonalInformation) {
        updateEmail(newPersonalInformation.getEmail());
        updatePassword(newPersonalInformation.getPassword());
        this.address = newPersonalInformation.getAddress();
        this.phoneNumber = newPersonalInformation.getPhoneNumber();
    }

    public boolean haveAnAppointmentOnSchedule(Schedule schedule) {
        // TODO: Querie to know if a patient already have an appointment on schedule
        return false;
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
