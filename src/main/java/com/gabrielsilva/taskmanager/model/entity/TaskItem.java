package com.gabrielsilva.taskmanager.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class TaskItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ds_it_task")
	private String itTaskName;
	
	@ManyToOne
	@JoinColumn(name = "id_task")
	private Task taskName;
	
	@Column(name = "yn_completed")
	private String ynCompleted;

}
