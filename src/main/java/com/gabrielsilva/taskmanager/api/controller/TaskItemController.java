package com.gabrielsilva.taskmanager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsilva.taskmanager.api.dto.TaskItemDTO;
import com.gabrielsilva.taskmanager.model.entity.TaskItem;
import com.gabrielsilva.taskmanager.model.repository.TaskItemRepository;
import com.gabrielsilva.taskmanager.service.TaskItemService;

@RestController
@RequestMapping(value = "/taskitem")
public class TaskItemController {
	
	@Autowired
	private TaskItemService service;
	
	@Autowired
	private TaskItemRepository repository;
	
	@GetMapping
	public List<TaskItem> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody TaskItemDTO dto) {
		try {
			TaskItem taskItem = service.convertDTO(dto);
			taskItem = service.saveTaskItem(taskItem);
			return new ResponseEntity<Object>(taskItem,HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity complete(@PathVariable Long id, @RequestBody TaskItemDTO dto) {
			return service.search(id).map( entity -> {
				try {
					TaskItem taskItem = service.convertDTO(dto);
					taskItem.setId(entity.getId());
					service.completeTaskItem(taskItem);
					return ResponseEntity.ok(taskItem);					
				} catch (Exception e) {
					return ResponseEntity.badRequest().body(e.getMessage());
				}
		}).orElseGet( () -> new ResponseEntity("Task Item cannot be found.", HttpStatus.BAD_REQUEST));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return service.search(id).map( entity -> {
			service.deleteTaskItem(entity);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}).orElseGet( () -> new ResponseEntity("Task Item cannot be found.", HttpStatus.BAD_REQUEST));
	}

}
