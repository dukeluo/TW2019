package com.tw.task01;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

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

    private Employee findById(int id) {
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        if (employeeList.size() == 0) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        Employee employee = findById(id);

        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employeeList.remove(employee);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee exitedEmployee = findById(employee.getId());

        if (exitedEmployee == null) {
            employeeList.add(employee);
            return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PATCH, produces = "application/json; charset=utf-8")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Map<String, Object> fields) {
        Employee exitedEmployee = findById(id);

        if (exitedEmployee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        } else {
            fields.forEach((k, v) -> {
                Field field = ReflectionUtils.findField(Employee.class, k);
                assert field != null;
                ReflectionUtils.setField(field, exitedEmployee, v);

            });
            return new ResponseEntity<Employee>(exitedEmployee, HttpStatus.OK);
        }
    }

}

