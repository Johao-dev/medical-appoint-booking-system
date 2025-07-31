package zuzz.projects.medical_appointment_booking_system.domain.model;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
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
        Doctor other = (Doctor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (speciality == null) {
            if (other.speciality != null)
                return false;
        } else if (!speciality.equals(other.speciality))
            return false;
        return true;
    }
}
