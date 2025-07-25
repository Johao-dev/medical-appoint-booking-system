package zuzz.projects.medical_appointment_booking_system.application.dto;

import java.time.Instant;

public class AuditLogFilters {

    private final Long userId;
    private final Instant endDate;
    private final Instant startDate;
    private final String actionType;
    private final String entityType;

    private AuditLogFilters(AuditLogFilters.Builder builder) {
        this.userId = builder.userId;
        this.endDate = builder.endDate;
        this.startDate = builder.startDate;
        this.actionType = builder.actionType;
        this.entityType = builder.entityType;
    }

    public static class Builder {
        private Long userId;
        private Instant endDate;
        private Instant startDate;
        private String actionType;
        private String entityType;

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder endDate(Instant endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder startDate(Instant startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder actionType(String actionType) {
            this.actionType = actionType;
            return this;
        }

        public Builder entityType(String entityType) {
            this.entityType = entityType;
            return this;
        }

        public AuditLogFilters build() {
            return new AuditLogFilters(this);
        }
    }

    public Long getUserId() {
        return userId;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public String getActionType() {
        return actionType;
    }

    public String getEntityType() {
        return entityType;
    }
}
