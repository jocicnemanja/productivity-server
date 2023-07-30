package com.server.productivity.HabitTracker.Habit;
import com.server.productivity.HabitTracker.HabitRecord.HabitRecord;
import com.server.productivity.utils.Base;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
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

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HabitRecord> habitRecords = new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HabitRecord )) return false;
        return id != (((HabitRecord) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
//    @ManyToOne
//    @JoinColumn(name="user_id",  nullable=false)
//    private User user;

}
