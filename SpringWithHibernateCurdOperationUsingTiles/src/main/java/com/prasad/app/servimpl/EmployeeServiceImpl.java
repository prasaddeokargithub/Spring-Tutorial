package com.prasad.app.servimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prasad.app.bean.Employee;
import com.prasad.app.daoi.IEmployeeDao;
import com.prasad.app.servi.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService 
{
	@Autowired
	IEmployeeDao iEmployeeDao;

	public void addEmployee(Employee employee) 
	{
		System.out.println("Service implemntation Add Employee"+employee.getName());
		iEmployeeDao.addNewEmployee(employee);
		// TODO Auto-generated method stub
	} 
	public List<Employee> employeeList() 
	{
		
		List<Employee> list=iEmployeeDao.listEmployee();
		return list;
	}
	
	public void deleteEmployee(int id) 
	{
		iEmployeeDao.delteEmployeeDao(id);

	}
	public List<Employee> employeeEditService(int id) 
	{	
	List<Employee> list=	iEmployeeDao.employeeEdit(id);
	
		return list;
	}
	public void updateEmployeeService(Employee employee) 
	{
	 iEmployeeDao.updateEmployee(employee);  	
	}

}
