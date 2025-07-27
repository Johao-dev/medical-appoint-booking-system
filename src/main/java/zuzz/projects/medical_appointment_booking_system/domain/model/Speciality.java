package zuzz.projects.medical_appointment_booking_system.domain.model;

public class Speciality {

    private Long id;
    private String name;

    public Speciality(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean is(String specialityName) {
        return name.equals(specialityName);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}