package com.gabrielsilva.taskmanager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielsilva.taskmanager.model.entity.Task;
import com.gabrielsilva.taskmanager.model.repository.TaskRepository;
import com.gabrielsilva.taskmanager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository repository;
	
	@Override
	@Transactional
	public Task saveTask(Task task) {
		return repository.save(task);
	}

	@Override
	public Optional<Task> search(Long id) {	
		return repository.findById(id);
	}


}
