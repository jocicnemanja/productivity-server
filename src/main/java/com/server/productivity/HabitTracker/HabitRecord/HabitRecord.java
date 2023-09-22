package com.server.productivity.HabitTracker.HabitRecord;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.productivity.HabitTracker.Habit.Habit;
import com.server.productivity.utils.Base;
import jakarta.persistence.*;

@Entity
@Table(name="habit_records", schema = "test")
public class HabitRecord  extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habit_id")
    @JsonIgnore
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
