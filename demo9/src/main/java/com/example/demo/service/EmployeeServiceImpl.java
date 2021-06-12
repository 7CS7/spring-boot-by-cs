package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired
	public EmployeeRepository empRepo;
	@Override
	public List<Employee> findAll() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee findById(int id) {
		Employee e=null;
		Optional<Employee> res=empRepo.findById(id);
		if(res.isPresent()) {
			e=res.get();
		}
		else {
			throw new RuntimeException("Employee not found");
		}
		return e;
	}

	@Override
	public void update(Employee emp) {
		empRepo.save(emp);
		
	}

	@Override
	public void delete(int id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public List<Employee> search(String firstName, String lastName) {
		return empRepo.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(firstName, lastName);
		
	}

}
