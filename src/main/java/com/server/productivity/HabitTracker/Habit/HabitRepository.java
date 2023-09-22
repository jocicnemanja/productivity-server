package com.server.productivity.HabitTracker.Habit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long>, JpaSpecificationExecutor<Habit> {
   List<Habit> findByCreatedDateGreaterThanAndCreatedDateLessThan(Instant start, Instant end);

   @Query("SELECT habit FROM Habit habit " +
           "JOIN FETCH habit.habitRecords habitRecord " +
           "WHERE YEAR(habitRecord.createdDate) = YEAR(CURRENT_DATE) " +
           "AND MONTH(habitRecord.createdDate) = MONTH(CURRENT_DATE)" +
           "AND YEAR(habit.createdDate) = YEAR(CURRENT_DATE)" +
           "AND MONTH(habit.createdDate) = MONTH(CURRENT_DATE)")
   List<Habit> findRecordsWithJoinFromCurrentMonth();
}


