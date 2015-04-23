package com.prasad.app.servi;

import java.util.List;

import com.prasad.app.bean.Employee;
/**
 * @author Prasad Deokar-patil
 *
 */
public interface IEmployeeService 
{
	public void addEmployee(Employee employee);
	public List<Employee> employeeList();
    public void deleteEmployee(int id);
    public List<Employee> employeeEditService(int id);
    public void updateEmployeeService(Employee employee);
    
}
