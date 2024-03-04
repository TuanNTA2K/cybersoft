package com.cybersoft.demospringboot04.repository;


import com.cybersoft.demospringboot04.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository                                             //<Tên của Entity, kdl khóa chính>
public interface EmployeesRepository extends JpaRepository<EmployeesEntity,Integer> {
    List<EmployeesEntity> findByEmployeeNameAndSalary(String name, double salary) ;

}
