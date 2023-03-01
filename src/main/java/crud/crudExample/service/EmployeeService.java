package crud.crudExample.service;

import java.util.List;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.crudExample.entity.Employee;
import crud.crudExample.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return (List<Employee>)employeeRepository.findAll();
	}
	 
	public Employee getEmployeeById(Long id) {
		return employeeRepository.getById(id);
		
		
	}
	
	public void addEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	}
	
public void updateEmployee(Employee employee) {
	employeeRepository.save(employee);
}
public void deleteEmployeeById(Long id) {
	employeeRepository.deleteById(id);
}


}


