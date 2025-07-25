package zuzz.projects.medical_appointment_booking_system.shared;

import zuzz.projects.medical_appointment_booking_system.shared.enums.SortDirection;

public record PageRequest(int pageNumber, int pageSize, String sortBy, SortDirection sortDirection) {

}
