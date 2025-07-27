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

    public static Appointment of(Patient patient, Doctor doctor, DoctorAvailability doctorAvailability,
            AppointmentState state, String reason) {

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setDoctorAvailability(doctorAvailability);
        appointment.setState(state);
        appointment.setReason(reason);
        return appointment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public DoctorAvailability getDoctorAvailability() {
        return doctorAvailability;
    }

    public void setDoctorAvailability(DoctorAvailability doctorAvailability) {
        this.doctorAvailability = doctorAvailability;
    }

    public AppointmentState getState() {
        return state;
    }

    public void setState(AppointmentState state) {
        this.state = state;
    }

    public ScheduleManager getScheduleManager() {
        return scheduleManager;
    }

    public void setScheduleManager(ScheduleManager scheduleManager) {
        this.scheduleManager = scheduleManager;
    }

    @Override
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
