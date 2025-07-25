package zuzz.projects.medical_appointment_booking_system.application.ports.output;

import zuzz.projects.medical_appointment_booking_system.application.dto.AuditLogSearchParameters;
import zuzz.projects.medical_appointment_booking_system.shared.Page;
import zuzz.projects.medical_appointment_booking_system.shared.audit.AuditLog;

public interface AuditLogRepository {

    AuditLog create(AuditLog log);

    Page<AuditLog> findAllLogsByEntity(Long entityId, AuditLogSearchParameters searchParameters);

    Page<AuditLog> findAllLogsByUser(Long userId, AuditLogSearchParameters searchParameters);
}
