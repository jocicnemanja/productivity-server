package com.server.productivitykit.Habittracker;

import com.server.productivitykit.User.User;
import com.server.productivitykit.utils.CorsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/v1/habits")
public class HabitTrackerController {

    private final HabitTrackerService  habitTrackerService;
    private final Logger log = LoggerFactory.getLogger(CorsFilter.class);

    @Autowired
    public HabitTrackerController(HabitTrackerService habitTrackerService) {
        this.habitTrackerService = habitTrackerService;
    }

    @GetMapping
    public List<Habit> getHabits() {
    return this.habitTrackerService.getHabits();
 }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Habit> createHabit(@RequestBody Habit habit) {
        try {
            log.info("POST Habit", habit);
            Habit _habit = habitTrackerService.save(habit);
            return new ResponseEntity<>(_habit, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("POST Habit ERORR", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
