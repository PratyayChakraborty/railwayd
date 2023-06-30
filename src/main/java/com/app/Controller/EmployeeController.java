package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Exception.EmployeeException;
import com.app.Model.Employee;
import com.app.Service.EmployeeServiceImp;


@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeServiceImp ei;
//	http://localhost:8088/employee/create
	@PostMapping("/create")
	public String  addStudent(@RequestBody Employee e) throws EmployeeException {
		
		return ei.addEmployee(e);
		
	}
//	http://localhost:8088/employee/delete
	@DeleteMapping("/delete")
	public String deleString(@RequestParam int id) throws EmployeeException {
		
		return ei.deleteEmployee(id);
		
	}
//	http://localhost:8088/employee/getall
	@GetMapping("/getall")
	public List<Employee> getAllStudent() throws EmployeeException{
		
		return ei.getallEmployee();
	}
//	http://localhost:8088/employee/getbyid
// 	http://localhost:8088/employee/getbyid/?id=
	@GetMapping("/getbyid")
	public Employee getStudent(@RequestParam int id) throws EmployeeException{
		
		return ei.getallEmployeeById(id);
	}
//	http://localhost:8088/employee/update
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee e) throws EmployeeException{
		
		return ei.updateEmployee(e);
	}	
//	http://localhost:8088/employee/search
	@GetMapping("/search")
	public List<Employee> searchString(@RequestParam("query") String q) throws EmployeeException {
		
		return ei.searchEmployee(q);
		
	}	

}
