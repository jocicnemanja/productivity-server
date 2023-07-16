package com.server.productivity.Habittracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabitTrackerService {

    private final  HabitTrackerRepository habitTrackerRepository;

    @Autowired
    public HabitTrackerService(HabitTrackerRepository habitTrackerRepository) {
        this.habitTrackerRepository = habitTrackerRepository;
    }

    public List<Habit> getHabits(){
       return this.habitTrackerRepository.findAll();
   }

    public Habit save(Habit habit) {
        return this.habitTrackerRepository.save(habit);
    }

}
