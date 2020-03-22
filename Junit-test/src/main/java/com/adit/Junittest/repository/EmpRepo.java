package com.adit.Junittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adit.Junittest.dto.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

}
