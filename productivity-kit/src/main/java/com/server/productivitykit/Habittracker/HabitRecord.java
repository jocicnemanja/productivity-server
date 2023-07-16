package com.server.productivitykit.Habittracker;

import com.server.productivitykit.utils.Base;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

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
