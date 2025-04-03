package com.perlathebian.taskmanager.repository;

import com.perlathebian.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // custom queries to be defined if needed
}
