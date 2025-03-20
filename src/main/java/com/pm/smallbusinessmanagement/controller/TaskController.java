package com.pm.smallbusinessmanagement.controller;

import com.pm.smallbusinessmanagement.model.Task;
import com.pm.smallbusinessmanagement.model.User;
import com.pm.smallbusinessmanagement.service.TaskService;
import com.pm.smallbusinessmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createTask(@RequestParam("description") String description,
                                             @RequestParam("deadline") String deadline,
                                             @RequestParam("status") String status,
                                             @RequestParam("userId") Long userId,
                                             @RequestParam("employeeId") Long employeeId) {
        try {
            Optional<User> user = userService.findById(userId);
            if (user.isEmpty()) {
                return ResponseEntity.status(404).body("User not found");
            }

            LocalDateTime parsedDeadline = LocalDateTime.parse(deadline);
            taskService.createTask(description, parsedDeadline, status, user.orElse(null), employeeId);

            return ResponseEntity.ok("Task created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating task");
        }
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> findTasksByStatus(@PathVariable String status) {
        List<Task> tasks = taskService.findTasksByStatus(status);
        return ResponseEntity.ok(tasks);
    }
}
