package zuzz.projects.medical_appointment_booking_system.domain.model;

public class Doctor {

    private Long id;
    private User user;
    private Speciality speciality;

    public void assignSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public void updateUserDetails(User newUserData) {

    }

    public boolean hasSpeciality(Speciality speciality) {
        return false;
        // TODO: Checks if the doctor possesses a specific Speciality
    }

    public String getDoctorFullName() {
        return "";
    }
}
