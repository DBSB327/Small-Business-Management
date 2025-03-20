package com.pm.smallbusinessmanagement.repository;

import com.pm.smallbusinessmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<com.pm.smallbusinessmanagement.model.Task> findByStatus(String status);
}
