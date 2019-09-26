package com.vevor.sofaboot.mapper;

import com.vevor.sofaboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: xyw
 * @CreateDt: 2019-09-26
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
