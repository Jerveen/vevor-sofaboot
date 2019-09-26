package com.vevor.sofaboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description: 员工类
 * @Author: xyw
 * @CreateDt: 2019-09-26
 */

@Entity
// 指定关联的数据库的表名
@Table(name = "t_employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    /**
     * 部门
     */
    private Department department;
}
