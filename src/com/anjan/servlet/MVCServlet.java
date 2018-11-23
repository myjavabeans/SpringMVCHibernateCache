package com.anjan.servlet;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anjan.hibernate.bean.EmployeeBean;
import com.anjan.hibernate.bo.EmployeeBeanBO;

@Controller
public class MVCServlet {

	private EmployeeBeanBO employeeBeanBO;

	@Autowired(required = true)
	@Qualifier(value = "employeeBo")
	public void setPersonService(EmployeeBeanBO employeeBeanBO) {
		this.employeeBeanBO = employeeBeanBO;
	}

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String defaultPage(Model model, Locale locale) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		List<EmployeeBean> list = employeeBeanBO.getAllEmployee();
		
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("listEmployees", list);
		
		return "index";
	}

	@RequestMapping(value="/addEmp", method = RequestMethod.POST)
	public String addEmployeeData(@Validated EmployeeBean empBean, Model model) {
		
		if(empBean.getId() == 0){
			employeeBeanBO.saveEmployee(empBean);
		}else{
			employeeBeanBO.updateEmployee(empBean);
		}
		
		return "redirect:/default";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteEmployeeData(@PathVariable("id") int id){
		
		employeeBeanBO.deleteEmployee(id);
		
		return "redirect:/default";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editEmployeeData(@PathVariable("id") int id, Model model, Locale locale){
		
		EmployeeBean empBean = employeeBeanBO.getBeanById(id);
		
		List<EmployeeBean> list = employeeBeanBO.getAllEmployee();

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("employee", empBean);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("listEmployees", list);

		
		return "empData";
	}
	
	@RequestMapping(value="/edit/updateEmp")
	public String updateEmployeeData(@Validated EmployeeBean empBean, Model model) {
		
		if(empBean.getId() == 0){
			employeeBeanBO.saveEmployee(empBean);
		}else{
			employeeBeanBO.updateEmployee(empBean);
		}
		
		return "redirect:/default";
	}
	
}
