package com.gabrielsilva.taskmanager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsilva.taskmanager.model.entity.Task;
import com.gabrielsilva.taskmanager.model.repository.TaskRepository;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskRepository repository;
	
	@CrossOrigin
	@GetMapping
	public List<Task> findAll(){
		return repository.findAll();
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Task dto) {	
		Task task = Task.builder().taskDescription(dto.getTaskDescription()).build();
		try {
			Task savedTask = repository.save(task);
			return new ResponseEntity<Object>(savedTask,HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Cannot create Task.");
		}

	}
	
}
