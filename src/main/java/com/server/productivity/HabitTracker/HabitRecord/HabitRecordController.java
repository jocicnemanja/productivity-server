package com.server.productivity.HabitTracker.HabitRecord;


import com.server.productivity.HabitTracker.Habit.Habit;
import jakarta.persistence.criteria.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/habit-records")
public class HabitRecordController {

    private  final  HabitRecordService habitRecordService;

    @Autowired
    public HabitRecordController(HabitRecordService habitRecordService) {
        this.habitRecordService = habitRecordService;
    }
}
