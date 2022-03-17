package com.assignment.employeemanagement.controller;

import java.util.List;

import com.assignment.employeemanagement.mapper.EmployeeMapper;
import com.assignment.employeemanagement.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        employeeMapper.create(employee);
        return new ResponseEntity<>("Created Successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
        if (employeeMapper.findById(id) == null) {
            return new ResponseEntity<>("Updated Failed! Employee does not exists!", HttpStatus.BAD_REQUEST);
        }
        employee.setId(id);
        employeeMapper.update(employee);
        return new ResponseEntity<>("Updated Successfully!", HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployyee(@PathVariable long id) {
        employeeMapper.delete(id);
        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeMapper.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name) {
        return new ResponseEntity<>(employeeMapper.findByName("%"+name+"%"), HttpStatus.OK);
    }
}
