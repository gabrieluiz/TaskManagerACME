package com.gabrielsilva.taskmanager.service;

import com.gabrielsilva.taskmanager.model.entity.TaskItem;
import com.gabrielsilva.taskmanager.model.entity.enums.TaskItemStatus;

public interface TaskItemService {
	
	TaskItem saveTask(TaskItem taskItem);
	TaskItem updateTask(TaskItem taskItem);
	void completeTask(TaskItem taskItem, TaskItemStatus status);
	void deleteTask(TaskItem taskItem);

}
