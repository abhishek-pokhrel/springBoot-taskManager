package com.tutorial.taskmanager;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // Pre-populate with sample data
        public TaskService() {
            tasks.add(new Task(idCounter.getAndIncrement(),
                 "Learn Spring Boot", "Complete the tutorial"));
        tasks.add(new Task(idCounter.getAndIncrement(),
                 "Set up GitHub", "Create repository and push code"));
        }

    // GET all tasks
    public List<Task> getAllTasks() {
    return tasks;
    }

    // GET task by ID
    public Optional<Task> getTaskById(Long id) {
    return tasks.stream()
        .filter(t -> t.getId().equals(id))
        .findFirst();
    }

    // CREATE a new task
    public Task createTask(Task task) {
        task.setId(idCounter.getAndIncrement());
        task.setCompleted(false);
        tasks.add(task);
        return task;
    }

    // UPDATE (toggle completed)
    public Optional<Task> toggleTask(Long id) {
        return getTaskById(id).map(task -> {
            task.setCompleted(!task.isCompleted());
            return task;
        });
    }

    // DELETE a task
    public boolean deleteTask(Long id) {
        return tasks.removeIf(t -> t.getId().equals(id));
    }
}