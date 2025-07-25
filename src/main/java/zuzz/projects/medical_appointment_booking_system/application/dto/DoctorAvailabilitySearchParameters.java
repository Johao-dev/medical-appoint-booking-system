package zuzz.projects.medical_appointment_booking_system.application.dto;

import zuzz.projects.medical_appointment_booking_system.shared.PageRequest;

public class DoctorAvailabilitySearchParameters {

    private PageRequest pageRequest;
    private DoctorAvailabilityFilters filters;

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public DoctorAvailabilityFilters getFilters() {
        return filters;
    }

    public void setFilters(DoctorAvailabilityFilters filters) {
        this.filters = filters;
    }
}
