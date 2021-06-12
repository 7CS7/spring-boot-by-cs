package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
public List<Employee> findAll();
public Employee findById(int id);
public void update(Employee emp);
public void delete(int id);
public List<Employee> search(String firstName,String lastName);
}
