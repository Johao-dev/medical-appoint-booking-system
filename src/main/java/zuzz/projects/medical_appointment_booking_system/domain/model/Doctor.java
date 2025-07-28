package zuzz.projects.medical_appointment_booking_system.domain.model;

@SuppressWarnings("unused")
public class Doctor {

    private Long id;
    private User user;
    private Speciality speciality;

    private Doctor() {
    }

    public static Doctor createNew(User user, Speciality speciality) {
        Doctor newDoctor = new Doctor();
        newDoctor.id = 0L;
        newDoctor.user = user;
        newDoctor.speciality = speciality;

        return newDoctor;
    }

    public void assignSpeciality(Speciality speciality) {
        if (speciality == null) {
            throw new IllegalArgumentException("Speciality cannot be null");
        }
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

    public Speciality getSpeciality() {
        return speciality;
    }
}
