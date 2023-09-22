package com.server.productivity.HabitTracker.Habit;

import com.server.productivity.HabitTracker.HabitRecord.HabitRecord;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.time.LocalDate;

public class HabitSpecifications {

    public static Specification<Habit> hasRecordsForDateRange(Instant startDate, Instant endDate) {
        return (root, query, criteriaBuilder) -> {
            Join<HabitRecord, Habit> habitRecords = root.join("habitRecords");
            return criteriaBuilder.between(habitRecords.get("createdDate"), startDate, endDate);
        };
    }
}
