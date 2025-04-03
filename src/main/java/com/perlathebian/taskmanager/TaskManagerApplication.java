package com.perlathebian.taskmanager;

import com.perlathebian.taskmanager.model.Task;
import com.perlathebian.taskmanager.repository.TaskRepository;
import com.perlathebian.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {
	@Autowired
	private TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Task task = new Task();
		task.setTitle("Sample Task");
		task.setDescription("This is a sample task.");

		// Use SimpleDateFormat to parse a string into a Date object
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dueDate = sdf.parse("2025-05-01 10:00:00");
		task.setDueDate(dueDate);

		task.setCategory("Work");
		task.setStatus("Pending");

		Task savedTask = taskService.createTask(task);
		System.out.println("Task created: " + savedTask);

		// Get all tasks
		System.out.println("All tasks: " + taskService.getAllTasks());

		// Get task by ID (assuming the task ID is 6)
		System.out.println("Task with ID 6: " + taskService.getTaskById(6L));

		// Update task
		savedTask.setStatus("Completed");
		taskService.updateTask(savedTask.getId(), savedTask);
		System.out.println("Updated task: " + savedTask);

		// Delete task
//		taskService.deleteTask(savedTask.getId());
//		System.out.println("Task deleted with ID: " + savedTask.getId());
	}
}
