package zuzz.projects.medical_appointment_booking_system.application.dto;

import zuzz.projects.medical_appointment_booking_system.shared.PageRequest;

public class AuditLogSearchParameters {

    private PageRequest pageRequest;
    private AuditLogFilters filters;

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public AuditLogFilters getFilters() {
        return filters;
    }

    public void setFilters(AuditLogFilters filters) {
        this.filters = filters;
    }
}
