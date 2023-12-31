package com.server.productivity.HabitTracker.Habit;

import com.server.productivity.utils.CorsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("api/v1/habits")
public class HabitController {

    private final HabitService  habitService;
    private final Logger log = LoggerFactory.getLogger(CorsFilter.class);

    @Autowired
    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Habit> getHabitsWithRecordsFilteredByMonthAndYear(@RequestParam(required = false) int month, @RequestParam(required = false) int year) {
        return this.habitService.findByMonthAndYear(month,year);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Habit> createHabit(@RequestBody Habit habit) {
        try {
            Habit habitRes = habitService.save(habit);
            return new ResponseEntity<>(habitRes, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("POST Habit ERORR", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping
    public ResponseEntity<Habit> deleteHabit(@RequestBody Habit habit) {
        try {
            habitService.delete(habit);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {

            log.error("DELETE Habit ERORR", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
