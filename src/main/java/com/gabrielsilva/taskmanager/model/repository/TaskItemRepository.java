package com.gabrielsilva.taskmanager.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielsilva.taskmanager.model.entity.TaskItem;

public interface TaskItemRepository extends JpaRepository<TaskItem, Long>{

}
