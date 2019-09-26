package com.vevor.sofaboot.mapper;

import com.vevor.sofaboot.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: xyw
 * @CreateDt: 2019-09-26
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
