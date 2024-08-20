package com.example.taskmanagement.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskmanagement.model.Task;

public interface TaskRepository  extends JpaRepository<Task,Long>{

}
