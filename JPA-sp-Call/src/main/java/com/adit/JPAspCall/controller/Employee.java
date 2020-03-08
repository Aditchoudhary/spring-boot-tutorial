package com.adit.JPAspCall.controller;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
	      name = "Get_All_Employee",
	      procedureName = "GetAllEmployee",
	      resultClasses = Employee.class	    	     
	    ),
@NamedStoredProcedureQuery(
	      name = "GetTotalEmpCount",
	      procedureName = "GetTotalEmpCount",
	      parameters = {
	              @StoredProcedureParameter(name = "total", type = String.class, mode = ParameterMode.OUT)
	      }
	)
})
@Entity
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1456455017653089200L;
	
	@Id
	private Long empid;
	private String companyName;
	private String name;
	
	@Column(name="empid")
	public Long getEmpid() {
		return empid;
	}
	public void setEmpid(Long empid) {
		this.empid = empid;
	}
	@Column(name="companyname")
	public String getCompanyid() {
		return companyName;
	}
	public void setCompanyid(String companyName) {
		this.companyName = companyName;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
