package com.gabrielsilva.taskmanager.service;

import java.util.Optional;

import com.gabrielsilva.taskmanager.model.entity.Task;


public interface TaskService {
	
	Task saveTask(Task task);
	
	Optional<Task> search(Long id);

}
