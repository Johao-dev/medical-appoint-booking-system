package zuzz.projects.medical_appointment_booking_system.domain.model;

import zuzz.projects.medical_appointment_booking_system.shared.enums.AppointmentState;

public class Appointment {

    private Long id;
    private String reason;
    private Doctor doctor;
    private Patient patient;
    private DoctorAvailability doctorAvailability;
    private AppointmentState state;
    private ScheduleManager scheduleManager;

    private Appointment(Patient patient, Doctor doctor, DoctorAvailability doctorAvailability,
        AppointmentState initialState, String reason) {
        this.patient = patient;
        this.doctor = doctor;
        this.doctorAvailability = doctorAvailability;
        this.state = initialState;
        this.reason = reason;
    }

    public static Appointment of(Patient patient, Doctor doctor, DoctorAvailability doctorAvailability,
            AppointmentState state, String reason) {
        return new Appointment(patient, doctor, doctorAvailability, state, reason);
    }

    public void cancel() {
        // TODO: It can only be cancelled if it is in PENDING or CONFIRMED.
    }

    public void confirm() {
        // TODO: It can only be confirmed if it is in PENDING.
    }

    public void reject() {
        // TODO: It can only be rejected if it is in PENDING.
    }

    public void complete() {
        // TODO: It can only be completed if it is in CONFIRMED.
    }

    public void expire() {
        // TODO: It can only expire if it is PENDING or CONFIRMED (and the date has passed)
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
        result = prime * result + ((patient == null) ? 0 : patient.hashCode());
        result = prime * result + ((doctorAvailability == null) ? 0 : doctorAvailability.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Appointment other = (Appointment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (doctor == null) {
            if (other.doctor != null)
                return false;
        } else if (!doctor.equals(other.doctor))
            return false;
        if (patient == null) {
            if (other.patient != null)
                return false;
        } else if (!patient.equals(other.patient))
            return false;
        if (doctorAvailability == null) {
            if (other.doctorAvailability != null)
                return false;
        } else if (!doctorAvailability.equals(other.doctorAvailability))
            return false;
        return true;
    }
}
