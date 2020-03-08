package com.adit.JPAspCall.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adit.JPAspCall.repository.EmployeeRepo;

@RestController
public class SpCallController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private EmployeeRepo repo;

	@GetMapping(path = "/sp/outparam")
	public String getoutparam() {

		StoredProcedureQuery procedureQuery = em.createNamedStoredProcedureQuery("GetTotalEmpCount");
		procedureQuery.execute();
		String value = (String) procedureQuery.getOutputParameterValue("total");
		return value;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(path = "/sp/all")
	public ResponseEntity<List<Employee>> getAllEmp() {

		StoredProcedureQuery procedureQuery = em.createNamedStoredProcedureQuery("Get_All_Employee");
		procedureQuery.execute();
		List<Employee> employees = procedureQuery.getResultList();

		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping(path = "/sp/all/jpaRepo")
	public ResponseEntity<List<Employee>> getAllEmpJpaRepo() {
		List<Employee> employees = repo.getAllEmployee();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping(path = "/sp/outparam/jpaRepo")
	public String getOutParamUsingSpringJpaRepo() {
		String value = (String) repo.inAndOutTest();
		return value;
	}
}
