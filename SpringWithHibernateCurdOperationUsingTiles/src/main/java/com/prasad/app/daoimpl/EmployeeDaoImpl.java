package com.prasad.app.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.prasad.app.bean.Employee;
import com.prasad.app.daoi.IEmployeeDao;

/**
 * @author prasad deokar
 *
 */
public class EmployeeDaoImpl implements IEmployeeDao
{
	@Autowired
	private SessionFactory hibernateSessionFactory;



	public SessionFactory getHibernateSessionFactory() {
		return hibernateSessionFactory;
	}

	public void setHibernateSessionFactory(SessionFactory hibernateSessionFactory) {
		this.hibernateSessionFactory = hibernateSessionFactory;
	}

	public void addNewEmployee(Employee employee) 
	{
		try{
			Session session=hibernateSessionFactory.openSession();
			session.saveOrUpdate(employee);
			System.out.println("Successfully inserted");
		}
		catch(Exception e){System.out.println(e);}
	}

	public List<Employee> listEmployee() 
	{

		List<Employee> employeelist = null;

		Session session=hibernateSessionFactory.openSession();

		employeelist	=session.createQuery("from Employee").list();
		System.out.println(employeelist);
		return employeelist;
	}

	public void delteEmployeeDao(int id)
	{
		try{
			Session session=hibernateSessionFactory.openSession();
			Employee employee=(Employee)session.load(Employee.class,id);

			if(employee!=null)
			{
				session.delete(employee);
				session.beginTransaction().commit();
			}

		}   catch(Exception e){System.out.println(e);}
	}
/*edit page employee Object*/
	public List<Employee> employeeEdit(int id) 
	{
		List<Employee> list=null;
		try
		{
			Session session=hibernateSessionFactory.openSession();
			Employee employee=(Employee)session.load(Employee.class,id);
			list=new ArrayList<Employee>();
			list.add(employee);

		}
		catch(Exception e)
		{
			e.printStackTrace();
				
		}
		return list ;
	}
/*Update Employee*/
	public void updateEmployee(Employee employee) 
	{
	  try
	  {
		 Session session=hibernateSessionFactory.openSession();
		 System.out.println(employee.getId());
		 session.update(employee);
		 session.beginTransaction().commit();
		 System.out.println("Employee updated ");
	  }catch(Exception e){System.out.println(e);}
		
	}


}
