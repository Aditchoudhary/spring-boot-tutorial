package com.adit.Junittest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adit.Junittest.dto.Employee;
import com.adit.Junittest.service.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/employee/{empid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empid") Long id){
		
		return new ResponseEntity<Employee>(empService.getEmployee(id), HttpStatus.OK);
	}

}
