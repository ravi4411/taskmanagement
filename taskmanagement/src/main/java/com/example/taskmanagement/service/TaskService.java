package com.example.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanagement.exception.ResourceNotFoundException;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.respository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	
	public Task createTask(Task task) {
		//Buisness logic for creating task
		return taskRepository.save(task);
	}
	
	public List<Task> getAllTasks(){
		//Buisness logic for retrieving all tasks
		return taskRepository.findAll();
	}
	
	public Task updateTask(Long taskId, Task updatedDetails) {
		//Buisness Logic for updating existing task
		
		Task existingTask = taskRepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId));
		existingTask.setTitle(updatedDetails.getTitle());
		existingTask.setDescription(updatedDetails.getDescription());
		existingTask.setDueDate(updatedDetails.getDueDate());
		return taskRepository.save(existingTask);
				
	}
	
	

}
