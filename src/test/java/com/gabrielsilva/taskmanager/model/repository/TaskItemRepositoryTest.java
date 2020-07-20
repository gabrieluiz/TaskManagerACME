package com.gabrielsilva.taskmanager.model.repository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gabrielsilva.taskmanager.model.entity.TaskItem;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TaskItemRepositoryTest {

	@Autowired
	TaskItemRepository repository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void mustSaveTaskItem() {
		TaskItem taskItem = createTaskItem();

		taskItem = repository.save(taskItem);
		assertThat(taskItem.getId()).isNotNull();
	}

	@Test
	public void mustDeleteTaskItem() {
		TaskItem taskItem = createAndPersistItem();

		entityManager.find(TaskItem.class, taskItem.getId());
		repository.delete(taskItem);
		TaskItem inexistentItem = entityManager.find(TaskItem.class, taskItem.getId());
		assertThat(inexistentItem).isNull();
	}

	@Test
	public void mustCompleteTaskItem() {
		TaskItem taskItem = createAndPersistItem();

		taskItem.setStatus(true);
		repository.save(taskItem);
		TaskItem completedItem = entityManager.find(TaskItem.class, taskItem.getId());
		assertThat(completedItem.isStatus()).isTrue();
	}

	@Test
	public void mustSearchItemById() {
		TaskItem taskItem = createAndPersistItem();

		Optional<TaskItem> ItemFound = repository.findById(taskItem.getId());
		assertThat((ItemFound).isPresent()).isTrue();
	}

	public static TaskItem createTaskItem() {
		TaskItem taskItem = TaskItem.builder().itTaskDescription("Task Item").build();
		return taskItem;
	}

	private TaskItem createAndPersistItem() {
		TaskItem taskItem = createTaskItem();
		taskItem = entityManager.persist(taskItem);
		return taskItem;
	}

}
