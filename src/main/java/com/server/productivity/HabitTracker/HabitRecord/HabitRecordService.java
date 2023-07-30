package com.server.productivity.HabitTracker.HabitRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitRecordService {

    private final HabitRecordRepository habitRecordRepository;

    @Autowired
    public HabitRecordService(HabitRecordRepository habitRecordRepository) {
        this.habitRecordRepository = habitRecordRepository;
    }

    public HabitRecord save(HabitRecord habitRecord){
       return   this.habitRecordRepository.save(habitRecord);
    }
}