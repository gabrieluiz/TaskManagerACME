package com.gabrielsilva.taskmanager.service;

import java.util.Optional;

import com.gabrielsilva.taskmanager.api.dto.TaskItemDTO;
import com.gabrielsilva.taskmanager.model.entity.TaskItem;


public interface TaskItemService {
	
	TaskItem saveTaskItem(TaskItem taskItem);
	
	TaskItem completeTaskItem(TaskItem taskItem);
	
	void deleteTaskItem(TaskItem taskItem);
	
	TaskItem convertDTO(TaskItemDTO dto);
	
	Optional<TaskItem> search(Long id);
}
