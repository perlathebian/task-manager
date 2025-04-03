package com.perlathebian.taskmanager;

import com.perlathebian.taskmanager.model.Task;
import com.perlathebian.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// testing the repo
		Task task = new Task();
		task.setTitle("Test Task");
		task.setDescription("This is a test task");
		task.setDueDate(new java.util.Date());
		task.setCategory("Work");
		task.setStatus("Pending");

		taskRepository.save(task); // saves task to database
		System.out.println("Task saved: " + task.getTitle());

		// fetch and display all tasks
		taskRepository.findAll().forEach(t -> System.out.println(t.getTitle()));
	}
}
