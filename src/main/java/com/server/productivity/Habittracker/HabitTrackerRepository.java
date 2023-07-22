package com.server.productivity.Habittracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface HabitTrackerRepository  extends JpaRepository<Habit, Long> {
   List<Habit> findByCreatedDateGreaterThanAndCreatedDateLessThan(Instant start, Instant end);
}
