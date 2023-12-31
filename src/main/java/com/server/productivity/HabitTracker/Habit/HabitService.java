package com.server.productivity.HabitTracker.Habit;
import com.server.productivity.HabitTracker.HabitRecord.HabitRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    @Autowired
    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> getHabitsByDate(){
        LocalDate currentDate = LocalDate.now();

        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        Instant startOfMonthInstant = firstDayOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant();

        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        Instant endOfMonthInstant = lastDayOfMonth.atStartOfDay(ZoneId.systemDefault()).plusDays(1).minusNanos(1).toInstant();

        List<Habit> habits = this.habitRepository.findByCreatedDateGreaterThanAndCreatedDateLessThan(startOfMonthInstant,endOfMonthInstant);

        return habits;
   }

    public List<Habit> findByMonthAndYear(int month, int year){
        return  this.habitRepository.findByMonthAndYear(month,year);
    }

    public Habit save(Habit habit) {
        LocalDate currentDate = LocalDate.now();
        for (int i = 0;  i < currentDate.lengthOfMonth(); i++){
            HabitRecord habitRecord = new HabitRecord();
            habitRecord.setStatus("NOT_DONE");
            habit.getHabitRecords().add(habitRecord);
            habitRecord.setHabit(habit);
        }

        return this.habitRepository.save(habit);
    }

    public void delete(Habit habit) {
         this.habitRepository.delete(habit);
    }

}
