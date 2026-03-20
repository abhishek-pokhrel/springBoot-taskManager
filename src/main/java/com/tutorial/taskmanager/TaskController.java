<<<<<<< HEAD
package com.tutorial.taskmanager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {
    private final TaskService taskService;

    // Spring auto-injects TaskService here
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET /api/tasks - List all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // GET /api/tasks/{id} - Get one task
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/tasks - Create a task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // PUT /api/tasks/{id}/toggle - Toggle complete
    @PutMapping("/{id}/toggle")
    public ResponseEntity<Task> toggleTask(@PathVariable Long id) {
        return taskService.toggleTask(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/tasks/{id} - Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.deleteTask(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
=======
package com.tutorial.taskmanager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {
    private final TaskService taskService;

    // Spring auto-injects TaskService here
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
 
    // GET /api/tasks - List all tasks
    @GetMapping
    public List<Task> getAllTasks() {
    return taskService.getAllTasks();
    }

    // GET /api/tasks/{id} - Get one task
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
    return taskService.getTaskById(id)
    .map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/tasks - Create a task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
    return taskService.createTask(task);
    }

    // PUT /api/tasks/{id}/toggle - Toggle complete
    @PutMapping("/{id}/toggle")
    public ResponseEntity<Task> toggleTask(@PathVariable Long id) {
    return taskService.toggleTask(id)
    .map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/tasks/{id} - Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
    if (taskService.deleteTask(id)) {
        return ResponseEntity.ok().build();
        }
    return ResponseEntity.notFound().build();
    }
}
>>>>>>> f7c348ed0a38f9a4e22cd64ab02b20899066cfd6
