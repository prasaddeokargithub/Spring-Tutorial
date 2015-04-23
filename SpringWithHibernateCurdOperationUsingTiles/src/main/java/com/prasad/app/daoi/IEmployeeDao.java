package com.prasad.app.daoi;

import java.util.List;

import com.prasad.app.bean.Employee;

/**
 * @author SONU
 *
 */
public interface IEmployeeDao {
	public void addNewEmployee(Employee employee);
	public List<Employee> listEmployee();
    public void delteEmployeeDao(int id); 
    public List<Employee> employeeEdit(int id);
    public void updateEmployee(Employee employee);
    
   
}
