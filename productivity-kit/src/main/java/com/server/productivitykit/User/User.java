package com.server.productivitykit.User;

import com.server.productivitykit.Habittracker.Habit;
import com.server.productivitykit.utils.Base;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private boolean enabled;

//    @OneToMany(mappedBy = "user")
//    private List<Habit> habits;

    // Getters and Setters

    // ...

    // Additional methods as needed

    // ...
}
