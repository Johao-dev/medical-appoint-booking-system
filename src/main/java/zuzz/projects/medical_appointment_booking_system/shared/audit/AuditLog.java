package zuzz.projects.medical_appointment_booking_system.shared.audit;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public final class AuditLog {

    private Long id;
    private Long userId;
    private String actionType;
    private Long entityId;
    private String entityType;
    private String details;
    private LocalDateTime timestamp;

    private AuditLog(AuditLog.Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.actionType = builder.actionType;
        this.entityId = builder.entityId;
        this.entityType = builder.entityType;
        this.details = builder.details;
        this.timestamp = builder.timestamp;
    }

    public static class Builder {

        private Long id;
        private Long userId;
        private String actionType;
        private Long entityId;
        private String entityType;
        private String details;
        private LocalDateTime timestamp;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder actionType(String actionType) {
            this.actionType = actionType;
            return this;
        }

        public Builder entityId(Long entityId) {
            this.entityId = entityId;
            return this;
        }

        public Builder entityType(String entityType) {
            this.entityType = entityType;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public AuditLog build() {
            return new AuditLog(this);
        }
    }
}