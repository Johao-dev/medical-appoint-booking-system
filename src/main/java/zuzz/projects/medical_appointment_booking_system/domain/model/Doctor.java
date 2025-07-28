package zuzz.projects.medical_appointment_booking_system.domain.model;

public class Doctor {

    private Long id;
    private User user;
    private Speciality speciality;

    public void assignSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public void updateUserDetails(User newUserData) {
        this.user = newUserData;
    }

    public boolean hasSpeciality(Speciality speciality) {
        return this.speciality.equals(speciality);
    }

    public String getDoctorFullName() {
        return user.getFullName();
    }
}
