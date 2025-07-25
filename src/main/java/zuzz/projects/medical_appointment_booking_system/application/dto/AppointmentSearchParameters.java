package zuzz.projects.medical_appointment_booking_system.application.dto;

import zuzz.projects.medical_appointment_booking_system.shared.PageRequest;

public class AppointmentSearchParameters {

    private PageRequest pageRequest;
    private AppointmentFilters filters;

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public AppointmentFilters getFilters() {
        return filters;
    }

    public void setFilters(AppointmentFilters filters) {
        this.filters = filters;
    }
}
