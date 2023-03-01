package crud.crudExample.controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import crud.crudExample.entity.Employee;
import crud.crudExample.service.EmployeeService;

@RestController
public class EmployeeController {

	EmployeeService employeeService;
	
	//get all employees list
	
	@GetMapping("/employeelist")
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employee/{id}")
	
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	
	@PostMapping("employee")
	public void addEmployee(@RequestBody Employee employee) {
		
		employeeService.addEmployee(employee);
		
	}
	
	
	@PutMapping("updateEmployee/{id}")
	
	public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		
	Employee oldEmployee=employeeService.getEmployeeById(id);
		oldEmployee.setFirstName(employee.getFirstName());
		oldEmployee.setLastName(employee.getLastName());
		oldEmployee.setEmail(employee.getEmail());
		employeeService.updateEmployee(oldEmployee);
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public void deleteEmployeeById(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
	}
}






