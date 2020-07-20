package com.gabrielsilva.taskmanager.model.repository;


import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gabrielsilva.taskmanager.model.entity.Task;



@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TaskRepositoryTest {

	@Autowired
	TaskRepository taskRepo;

	@Test
	public void mustSaveTask() {		
		Task task = createTask();	
		Task savedTask = taskRepo.save(task);
		
		assertThat(savedTask.getId()).isNotNull();	
	}

	private Task createTask() {
		Task task = Task.builder().taskDescription("task 1").build();
		return task;
	}
	

}
