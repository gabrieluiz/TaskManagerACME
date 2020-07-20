package com.gabrielsilva.taskmanager.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskItemDTO {
	
	private Long id;
	private String itTaskDescription;
	private Long task;
	private boolean status;

}
