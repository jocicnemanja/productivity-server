package com.server.productivitykit.Habittracker;
import com.server.productivitykit.utils.Base;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "habits")
public class Habit extends Base {
    @Id
    @SequenceGenerator(
        name="habit_sequence",
        sequenceName = "habit_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "habit_sequence"
    )
    private long id;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "habit")
    private List<HabitRecord> habitRecords;

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

    public List<HabitRecord> getHabitRecords() {
        return habitRecords;
    }

    public void setHabitRecords(List<HabitRecord> habitRecords) {
        this.habitRecords = habitRecords;
    }
//    @ManyToOne
//    @JoinColumn(name="user_id",  nullable=false)
//    private User user;

}
