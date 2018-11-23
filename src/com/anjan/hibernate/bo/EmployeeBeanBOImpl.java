package com.anjan.hibernate.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjan.hibernate.bean.EmployeeBean;
import com.anjan.hibernate.dao.EmployeeDao;

/**
 * Service Class
 * @author Anjan
 *
 */

@Service
public class EmployeeBeanBOImpl implements EmployeeBeanBO{

	EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void saveEmployee(EmployeeBean eb) {
		employeeDao.saveEmployee(eb);
	}

	@Override
	public void updateEmployee(EmployeeBean eb) {
		employeeDao.updateEmployee(eb);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}

	@Override
	public EmployeeBean getBeanById(int id) {
		return employeeDao.getBeanById(id);
	}

	@Override
	public List<EmployeeBean> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	
}
