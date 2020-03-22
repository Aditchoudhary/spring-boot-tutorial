package com.adit.Junittest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adit.Junittest.dto.Employee;
import com.adit.Junittest.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;
	
	public Employee getEmployee(Long id){
	Optional<Employee> optionalEmp	=  empRepo.findById(id);
	return optionalEmp.isPresent() ? optionalEmp.get() : null;
	}
}
