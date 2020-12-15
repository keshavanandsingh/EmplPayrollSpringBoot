package com.blz.emppayroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blz.emppayroll.model.EmployeePayroll;
import com.blz.emppayroll.service.IEmployeePayrollService;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {
//	@Autowired
//	EmployeePayrollRepository employeePayrollRepository;
	@Autowired
	private IEmployeePayrollService employeePayrollService;

	// get all employees
	@GetMapping("/employees")
	public List<EmployeePayroll> getAllEmployees() {
		return employeePayrollService.getEmployeePayrollData();
	}

	// get employee by id
	@GetMapping("/employees/{empId}")
	public EmployeePayroll getAllEmployeeById(@PathVariable("empId") int empId) {
		return employeePayrollService.getEmployeePayrollDataById(empId);
	}

	// create employee rest api
	@PostMapping("/employees")
	public EmployeePayroll createEmployee(@RequestBody EmployeePayroll employee) {
		return employeePayrollService.createEmployeePayrollData(employee);
	}

	@PutMapping("employee/update/{empId}")
	public EmployeePayroll updateEmployeePayrollData(@PathVariable("empId") int empId,
			@RequestBody EmployeePayroll empPayroll) {
		return employeePayrollService.updateEmployeePayrollData(empId, empPayroll);
	}

	@DeleteMapping("employee/delete/{empId}")
	public String deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		return "Deleted Successfully and Deleted Id: " + empId;
	}

}
