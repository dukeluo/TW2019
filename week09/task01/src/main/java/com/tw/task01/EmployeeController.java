package com.tw.task01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class EmployeeController {
    private List<Employee> employeeList = new ArrayList<Employee>();

    {
        employeeList.add(new Employee(0, "小明", 20, "男"));
        employeeList.add(new Employee(1, "小红", 19, "女"));
        employeeList.add(new Employee(2, "小智", 15, "男"));
        employeeList.add(new Employee(3, "小刚", 16, "男"));
        employeeList.add(new Employee(4, "小霞", 15, "女"));
    }

    @RequestMapping("/employees")
    public List<Employee> findAll() {
        return employeeList;
    }
}

