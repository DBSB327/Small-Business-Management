package com.pm.smallbusinessmanagement.model;

import com.pm.smallbusinessmanagement.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<AuditLog> auditLogs;
    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
}