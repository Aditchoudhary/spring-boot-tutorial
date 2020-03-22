package com.adit.Junittest.ServiceTest;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adit.Junittest.dto.Employee;
import com.adit.Junittest.repository.EmpRepo;
import com.adit.Junittest.service.EmpService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)

public class EmpServiceTest {

	@InjectMocks
	private EmpService empService;
	
	@Mock
	private EmpRepo empRepo;
	
	@Test
	public void getEmpService(){
		
		Employee e = new Employee();
		e.setEmpid(1L);
		e.setName("adit");
		
		Optional<Employee> optionalEmp = Optional.of(e);
		Mockito.when(empRepo.findById(1L)).thenReturn(optionalEmp);
		
		Employee emp = empService.getEmployee(1L);
		assertEquals(emp.getName(), e.getName());
	}

	
}
