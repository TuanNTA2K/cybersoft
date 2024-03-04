package com.cybersoft.crm04.repository;

import com.cybersoft.crm04.entity.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskReponsitory extends JpaRepository<TasksEntity,Integer> {
}
