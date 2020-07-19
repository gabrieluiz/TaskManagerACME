package com.gabrielsilva.taskmanager.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielsilva.taskmanager.model.entity.TaskItem;
import com.gabrielsilva.taskmanager.model.entity.enums.TaskItemStatus;
import com.gabrielsilva.taskmanager.model.repository.TaskItemRepository;
import com.gabrielsilva.taskmanager.service.TaskItemService;

@Service
public class TaskItemServiceImpl implements TaskItemService{
	
	@Autowired
	private TaskItemRepository repository;

	@Override
	@Transactional
	public TaskItem saveTask(TaskItem taskItem) {
		return repository.save(taskItem);
	}
	
	@Override
	@Transactional
	public TaskItem updateTask(TaskItem taskItem) {
		Objects.requireNonNull(taskItem.getId());
		return repository.save(taskItem);
	}

	@Override
	public void completeTask(TaskItem taskItem, TaskItemStatus status) {
		taskItem.setStatus(status);
		updateTask(taskItem);
		
	}

	@Override
	@Transactional
	public void deleteTask(TaskItem taskItem) {
		Objects.requireNonNull(taskItem.getId());
		repository.delete(taskItem);
		
	}

}
