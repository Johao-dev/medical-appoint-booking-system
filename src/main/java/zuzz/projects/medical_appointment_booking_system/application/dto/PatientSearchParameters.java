package zuzz.projects.medical_appointment_booking_system.application.dto;

import zuzz.projects.medical_appointment_booking_system.shared.PageRequest;

public class PatientSearchParameters {

    private PageRequest pageRequest;
    private PatientFilters filters;

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public PatientFilters getFilters() {
        return filters;
    }

    public void setFilters(PatientFilters filters) {
        this.filters = filters;
    }
}
