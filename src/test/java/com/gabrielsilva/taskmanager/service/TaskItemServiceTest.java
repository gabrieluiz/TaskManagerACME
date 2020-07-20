package com.gabrielsilva.taskmanager.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gabrielsilva.taskmanager.model.entity.TaskItem;
import com.gabrielsilva.taskmanager.model.repository.TaskItemRepository;
import com.gabrielsilva.taskmanager.model.repository.TaskItemRepositoryTest;
import com.gabrielsilva.taskmanager.service.impl.TaskItemServiceImpl;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TaskItemServiceTest {
	
	@SpyBean
	TaskItemServiceImpl service;
	
	@MockBean
	TaskItemRepository repository;
	
	@Test
	public void mustCompleteTaskItem() {
//		TaskItem taskItem = TaskItemRepositoryTest.createTaskItem();
//
//		taskItem.setStatus(true);
//		Mockito.when(repository.save(taskItem)).thenReturn(taskItem);
//		
//		assertThat(taskItem.isStatus()).isTrue();
	}

}
