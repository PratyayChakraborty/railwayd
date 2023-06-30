package com.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exception.EmployeeException;
import com.app.Model.Employee;
import com.app.Repository.EmployeeRepo;
@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeRepo er;

	@Override
	public String addEmployee(Employee e) throws EmployeeException {
		er.save(e);
		return "Employee Added Successfully";
	}

	@Override
	public List<Employee> getallEmployee() throws EmployeeException {
		
		return er.findAll();
	}

	@Override
	public String deleteEmployee(Integer Id) throws EmployeeException {
	Optional<Employee> eo=	er.findById(Id);
	Employee e=eo.get();
		if(e==null) {
			throw new EmployeeException("Employee not found with this id");
		} else {
			er.delete(e);
		}
		return "Delete Successfull";
	}

	@Override
	public String updateEmployee(Employee e) throws EmployeeException {
	
		Optional<Employee> eo=	er.findById(e.getEmp_id());
		Employee ep=eo.get();
			if(ep==null) {
				throw new EmployeeException("Employee not found with this id");
			} else {
				er.save(e);
			}
			return "Update Successfull";
	}
	@Override
	public Employee getallEmployeeById(Integer id) throws EmployeeException{
		
		Optional<Employee> eo=	er.findById(id);
		Employee e=eo.get();
			if(e==null) {
				throw new EmployeeException("Employee not found with this id");
			} 
			return e;
	}

	@Override
	public List<Employee> searchEmployee(String query) throws EmployeeException {
		// TODO Auto-generated method stub
		return er.searchEmployees(query);
	}

}
