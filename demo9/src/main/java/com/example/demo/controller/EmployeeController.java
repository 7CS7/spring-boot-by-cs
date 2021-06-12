package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
private EmployeeService empSer;
	@GetMapping("/list")
	public String findAll(Model m) {
		List<Employee> e=empSer.findAll();
		m.addAttribute("listemployees", e);
		return "/employees/list-emp";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model m) {
		Employee e=new Employee();
		m.addAttribute("employee", e);
		return "/employees/add-emp";
	}
	@GetMapping("/showFormForUpdate")
	public String update(@RequestParam("employeeId")int theId,Model m) {
		Employee e=empSer.findById(theId);
		m.addAttribute("employee", e);
		return "/employees/add-emp";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("listemployees")Employee theEmp) {
		empSer.update(theEmp);
		return "redirect:/employee/list";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId")int theId) {
		empSer.delete(theId);
		return "redirect:/employee/list";
	}
	@GetMapping("/search")
	public String search(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,Model m) {
		List<Employee> e=empSer.search(firstName, lastName);
		m.addAttribute("listemployees", e);
		return "/employees/list-emp";
	}
}
