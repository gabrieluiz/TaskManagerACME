package com.gabrielsilva.taskmanager.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielsilva.taskmanager.api.dto.TaskItemDTO;
import com.gabrielsilva.taskmanager.model.entity.Task;
import com.gabrielsilva.taskmanager.model.entity.TaskItem;
import com.gabrielsilva.taskmanager.model.repository.TaskItemRepository;
import com.gabrielsilva.taskmanager.service.TaskItemService;
import com.gabrielsilva.taskmanager.service.TaskService;

@Service
public class TaskItemServiceImpl implements TaskItemService{
	
	@Autowired
	private TaskItemRepository repository;
	
	@Autowired
	private TaskService taskService;

	@Override
	@Transactional
	public TaskItem saveTaskItem(TaskItem taskItem) {
		return repository.save(taskItem);
	}
	
	@Override
	@Transactional
	public TaskItem completeTaskItem(TaskItem taskItem) {
		Objects.requireNonNull(taskItem.getId());
		taskItem.setStatus(true);
		return repository.save(taskItem);
	}

	@Override
	@Transactional
	public void deleteTaskItem(TaskItem taskItem) {
		Objects.requireNonNull(taskItem.getId());
		repository.delete(taskItem);
		
	}

	@Override
	public TaskItem convertDTO(TaskItemDTO dto) {
		TaskItem taskItem = new TaskItem();
		taskItem.setItTaskDescription(dto.getItTaskDescription());
		
		Task task = taskService.search(dto.getTask()).orElseThrow(() -> new RuntimeException("Task cannot be found."));
		
		taskItem.setTask(task);
		
		taskItem.setStatus(dto.isStatus());
		return taskItem;
	}

	@Override
	public Optional<TaskItem> search(Long id) {
		return repository.findById(id);
		
	}

}
