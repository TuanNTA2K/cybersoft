package com.cybersoft.crm04.repository;


import com.cybersoft.crm04.entity.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsReponsitory extends JpaRepository<JobsEntity,Integer> {
}
