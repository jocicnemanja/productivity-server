package com.server.productivity.Habittracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitTrackerRepository  extends JpaRepository<Habit, Long> {
}
