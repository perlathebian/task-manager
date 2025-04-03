package com.perlathebian.taskmanager.service;

import com.perlathebian.taskmanager.model.Task;
import com.perlathebian.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // method to save a new task
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    // method to get all tasks
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // method to get a task by id
    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    // method to update an existing task
    public Task updateTask(Long id, Task taskDetails){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found."));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        task.setCategory(taskDetails.getCategory());
        task.setStatus(taskDetails.getStatus());
        return taskRepository.save(task);
    }

    // method to delete a task
    public void deleteTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }
}
