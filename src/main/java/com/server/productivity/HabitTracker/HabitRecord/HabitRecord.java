package com.server.productivity.HabitTracker.HabitRecord;

import com.server.productivity.HabitTracker.Habit.Habit;
import com.server.productivity.utils.Base;
import jakarta.persistence.*;

@Entity
public class HabitRecord  extends Base {

    @Id
//    @SequenceGenerator(
//        name="habit_record_sequence",
//        sequenceName = "habit_record_sequence",
//        allocationSize = 1
//    )
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private long id;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Habit habit;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }
}