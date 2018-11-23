package com.anjan.hibernate.bo;

import java.util.List;

import com.anjan.hibernate.bean.EmployeeBean;

public interface EmployeeBeanBO {
	
	public void saveEmployee(EmployeeBean eb);
	public void updateEmployee(EmployeeBean eb);
	public void deleteEmployee(int id);
	public EmployeeBean getBeanById(int id);
	public List<EmployeeBean> getAllEmployee();
	
}
