package com.gabrielsilva.taskmanager.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielsilva.taskmanager.model.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	

}
