package zuzz.projects.medical_appointment_booking_system.domain.model;

import zuzz.projects.medical_appointment_booking_system.shared.enums.DocumentType;

public final class Patient extends User {

    private DocumentType identificationDocumentType;
    private String identificationDocumentNumber;
    private Character gender;
}
