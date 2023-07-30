package com.server.productivity.HabitTracker.Habit;
import com.server.productivity.HabitTracker.HabitRecord.HabitRecord;
import com.server.productivity.utils.Base;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "habits")
public class Habit extends Base {
    @Id
//    @SequenceGenerator(
//        name="habit_sequence",
//        sequenceName = "habit_sequence",
//        allocationSize = 1
//    )
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private long id;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "habit")
    private Set<HabitRecord> habitRecords = new HashSet<>();
//    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<HabitRecord> habitRecords = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<HabitRecord> getHabitRecords() {
        return habitRecords;
    }

    public void setHabitRecords(Set<HabitRecord> habitRecords) {
        this.habitRecords = habitRecords;
    }

    public void addRecord(HabitRecord habitRecord){
        habitRecords.add(habitRecord);
        habitRecord.setHabit(this);
    }
    public void removeRecord(HabitRecord habitRecord){
        habitRecords.remove(habitRecord);
        habitRecord.setHabit(null);
    }

}
