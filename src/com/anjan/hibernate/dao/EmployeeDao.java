package com.anjan.hibernate.dao;

import java.util.List;

import com.anjan.hibernate.bean.EmployeeBean;

public interface EmployeeDao {

	public void saveEmployee(EmployeeBean eb);
	public void updateEmployee(EmployeeBean eb);
	public void deleteEmployee(int id);
	public EmployeeBean getBeanById(int id);
	public List<EmployeeBean> getAllEmployee();
	
}
