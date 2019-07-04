package com.oocl.grow.service;

import com.oocl.grow.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();
}
