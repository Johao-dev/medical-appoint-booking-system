package zuzz.projects.medical_appointment_booking_system.shared.audit;

import java.time.LocalDateTime;

public record AuditLog(Long id, Long userId, String details, String actionType,
        String entityType, LocalDateTime actionTimestamp) {

}
