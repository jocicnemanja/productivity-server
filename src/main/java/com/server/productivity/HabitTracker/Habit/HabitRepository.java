package com.server.productivity.HabitTracker.Habit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
   List<Habit> findByCreatedDateGreaterThanAndCreatedDateLessThan(Instant start, Instant end);
}
