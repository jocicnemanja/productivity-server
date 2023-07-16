package com.server.productivitykit.Habittracker;

import com.server.productivitykit.User.User;
import com.server.productivitykit.utils.CorsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
