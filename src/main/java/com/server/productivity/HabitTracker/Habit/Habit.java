package com.server.productivity.HabitTracker.Habit;
import com.server.productivity.HabitTracker.HabitRecord.HabitRecord;
import com.server.productivity.utils.Base;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Join;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "habits", schema = "test")
public class Habit extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "habit")
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
        if (habitRecord != null) {
            if (habitRecords == null) {
                habitRecords = new HashSet<>();
            }

            habitRecords.add(habitRecord);
            // item.setOrder(this);
        }
    }

}
