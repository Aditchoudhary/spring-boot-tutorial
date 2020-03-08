package com.adit.JPAspCall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adit.JPAspCall.controller.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {

	@Procedure(name = "GetTotalEmpCount", outputParameterName="total")
    String inAndOutTest();
	
	@Procedure(name = "Get_All_Employee" )
	List<Employee> getAllEmployee();
	
}
