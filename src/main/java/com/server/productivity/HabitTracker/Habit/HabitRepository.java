package com.server.productivity.HabitTracker.Habit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long>, JpaSpecificationExecutor<Habit> {

   List<Habit> findByCreatedDateGreaterThanAndCreatedDateLessThan(Instant start, Instant end);

   @Query("SELECT habit FROM Habit habit " +
           "JOIN FETCH habit.habitRecords habitRecord " +
           "WHERE CAST(YEAR(habitRecord.createdDate) AS int) = :year " +
           "AND CAST(MONTH(habitRecord.createdDate) AS int) = :month " +
           "AND CAST(YEAR(habit.createdDate) AS int) = :year " +
           "AND CAST(MONTH(habit.createdDate) AS int) = :month")
   List<Habit> findByMonthAndYear(@Param("month") int month, @Param("year") int year);

}


