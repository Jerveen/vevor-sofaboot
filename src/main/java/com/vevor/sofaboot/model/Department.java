package com.vevor.sofaboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description: 部门类
 * @Author: xyw
 * @CreateDt: 2019-09-26
 */
@Entity
// 指定关联的数据库的表名
@Table(name = "t_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 部门名称
     */
    private String name;
}
