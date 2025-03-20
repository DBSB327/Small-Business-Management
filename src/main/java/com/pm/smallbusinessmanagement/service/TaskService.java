package com.pm.smallbusinessmanagement.service;

import com.pm.smallbusinessmanagement.model.Task;
import com.pm.smallbusinessmanagement.model.User;
import com.pm.smallbusinessmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public void createTask(String description, LocalDateTime deadline, String status, User user, Long employeeId) {
        Task task = new Task();
        task.setDescription(description);
        task.setDeadline(deadline);
        task.setStatus(status);
        task.setUser(user);
        task.setEmployee(userService.findEmployeeById(employeeId)); // Для примера, ищем сотрудника по ID

        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}

