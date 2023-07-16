package com.server.productivity.Habittracker;

import com.server.productivity.utils.Base;
import jakarta.persistence.*;

@Entity
public class HabitRecord  extends Base {

    @Id
    @SequenceGenerator(
        name="habit_record_sequence",
        sequenceName = "habit_record_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "habit_record_sequence"
    )
    private long id;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name="habit_id",  nullable=false)
    private Habit habit;
}
