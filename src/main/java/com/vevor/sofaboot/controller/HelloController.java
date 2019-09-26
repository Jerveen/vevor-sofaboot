package com.vevor.sofaboot.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.vevor.sofaboot.mapper.DepartmentRepository;
import com.vevor.sofaboot.mapper.EmployeeRepository;
import com.vevor.sofaboot.model.Department;
import com.vevor.sofaboot.model.Employee;
import com.vevor.sofaboot.sevice.HelloService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试Controller http://localhost:8090/swagger-ui.html
 * @Author: xyw
 * @CreateDt: 2019-09-23
 */
@RestController
public class HelloController {

    @SofaReference(interfaceType = HelloService.class, binding = @SofaReferenceBinding(bindingType = "bolt"))
    private HelloService helloService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/sayHello")
    public String sayHello(String name) {

        String result = helloService.sayHello(name);

        return result;
    }

    @ApiOperation(value = "保存员工信息", notes = "根据员工信息名以及部门信息保存员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "员工姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "departmentId", value = "部门信息", required = true, dataType = "Long")
    })
    @GetMapping("/saveEmployee")
    public Employee add(@RequestParam(name = "name", required = true) String name,
                        @RequestParam(name = "departmentId", required = true) Long departmentId) {
        Employee employee = new Employee();
        employee.setName(name);
        Department department = new Department();
        department.setId(departmentId);
        employee.setDepartment(department);
        employeeRepository.save(employee);
        return employee;
    }

    @GetMapping("/saveDepartment")
    public Department add(@RequestParam(name = "name", required = true) String name) {
        Department department = new Department();
        department.setName(name);
        departmentRepository.save(department);
        return department;
    }
}
