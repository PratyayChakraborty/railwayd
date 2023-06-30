package com.app.Service;

import java.util.List;

import com.app.Exception.EmployeeException;
import com.app.Model.Employee;

public interface EmployeeService {
	
	public String addEmployee(Employee e) throws EmployeeException;
	public List<Employee> getallEmployee() throws EmployeeException ;
	public String deleteEmployee(Integer Id)throws EmployeeException;
	public String updateEmployee(Employee e)throws EmployeeException;
	public Employee getallEmployeeById(Integer id)throws EmployeeException;
	public List<Employee> searchEmployee(String query) throws EmployeeException ;

}
