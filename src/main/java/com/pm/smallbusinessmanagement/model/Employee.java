package com.pm.smallbusinessmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactInfo;
    private String position;
    private Double salary;
    private String workSchedule;
    private Integer vacationDays;
    private Integer sickLeaveDays;
    @OneToMany(mappedBy = "employee")
    private List<Task> tasks;

}