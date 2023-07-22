package com.server.productivity.Habittracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class HabitTrackerService {

    private final  HabitTrackerRepository habitTrackerRepository;

    @Autowired
    public HabitTrackerService(HabitTrackerRepository habitTrackerRepository) {
        this.habitTrackerRepository = habitTrackerRepository;
    }

    public List<Habit> getHabitsByDate(){

        LocalDate currentDate = LocalDate.now();

        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        Instant startOfMonthInstant = firstDayOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant();

        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        Instant endOfMonthInstant = lastDayOfMonth.atStartOfDay(ZoneId.systemDefault()).plusDays(1).minusNanos(1).toInstant();

        List<Habit> habits = this.habitTrackerRepository.findByCreatedDateGreaterThanAndCreatedDateLessThan(startOfMonthInstant,endOfMonthInstant);
        habits.forEach(habit -> {
            List<HabitRecord> habitRecords = new ArrayList<HabitRecord>();
            for (int i=0; i<currentDate.lengthOfMonth(); i++ ){
                habitRecords.add(new HabitRecord());
            }
            habit.setHabitRecords(habitRecords);
        });

        return habits;
   }

    public Habit save(Habit habit) {
        return this.habitTrackerRepository.save(habit);
    }

    public void delete(Habit habit) {
         this.habitTrackerRepository.delete(habit);
    }


}
