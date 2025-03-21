package com.pm.smallbusinessmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    private String position;
    private Double salary;
    private String workSchedule;
    private Integer vacationDays;
    private Integer sickLeaveDays;

    @OneToMany(mappedBy = "employee")
    private List<Task> tasks;
}
