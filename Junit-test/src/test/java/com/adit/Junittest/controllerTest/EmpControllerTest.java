package com.adit.Junittest.controllerTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.adit.Junittest.controller.EmpController;
import com.adit.Junittest.dto.Employee;
import com.adit.Junittest.service.EmpService;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmpControllerTest {

	@Mock
	private EmpService empService;
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private EmpController empController;
	
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.standaloneSetup(empController).build();
	}
	
	@Test
	public void getEmp() throws Exception{
		
		Employee e = new Employee();
		e.setEmpid(1L);
		e.setName("adit");
		
		Mockito.when(empService.getEmployee(1L)).thenReturn(e);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/{id}",1L))
				.andExpect(MockMvcResultMatchers.status().isOk());
			
	}
	
}
