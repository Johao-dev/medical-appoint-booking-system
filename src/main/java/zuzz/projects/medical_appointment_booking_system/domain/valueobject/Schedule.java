package zuzz.projects.medical_appointment_booking_system.domain.valueobject;

import java.time.LocalTime;

import zuzz.projects.medical_appointment_booking_system.shared.enums.DayOfWeek;

// TODO: remove this class and all references to it

public class Schedule {

    private final DayOfWeek dayOfWeek;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Schedule(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean overlapsWith(Schedule other) {
        if (!isTheSameDay(other.getDayOfWeek())) {
            return false;
        }

        return isBeforeMyStartTime(other.getEndTime()) &&
            isAfterMyEndTime(other.getStartTime());
    }

    private boolean isTheSameDay(DayOfWeek otherDay) {
        return this.dayOfWeek.equals(otherDay);
    }

    private boolean isBeforeMyStartTime(LocalTime otherEndTime) {
        return this.startTime.isBefore(otherEndTime);
    }

    private boolean isAfterMyEndTime(LocalTime otherStartTime) {
        return otherStartTime.isBefore(this.endTime);
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
