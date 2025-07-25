package zuzz.projects.medical_appointment_booking_system.shared;

import java.util.List;

public record Page<T>(List<T> content, int pageNumber, int pageSize, long totalElements, int totalPages) {

}
