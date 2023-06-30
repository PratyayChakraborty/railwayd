package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.Model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT e FROM Employee e WHERE "
			+"e.first_name LIKE CONCAT('%',:query,'%') "
			+"OR e.last_name LIKE CONCAT('%',:query,'%') "
			+"OR e.mobile LIKE CONCAT('%',:query,'%')"
			+"OR e.email LIKE CONCAT('%',:query,'%')"
			+"OR e.address LIKE CONCAT('%',:query,'%')")
	List<Employee> searchEmployees(String query);
	

}
