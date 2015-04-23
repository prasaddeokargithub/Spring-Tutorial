package com.prasad.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prasad.app.bean.Employee;
import com.prasad.app.servi.IEmployeeService;

/**
 * @author Prasad Deokar
 *
 */
@Controller
public class EmployeeController 
{
@Autowired 
IEmployeeService iEmployeeService;	
	
	
@RequestMapping("/index")
	  public ModelAndView viewIndexPage()
	  {
		return new ModelAndView("redirect:getEmployeeList.html");
	  }
@RequestMapping("/getEmployeeList")
		public ModelAndView getEmployeeList() 
		{
	    List<Employee> list=null;
		try {
				
				list=iEmployeeService.employeeList();
			} 
		catch (Exception e) 
			{
			  e.printStackTrace();
				System.out.println(e);
			}
			return new ModelAndView("welcome","list",list);
		}
//registration form
@RequestMapping("/registerhere")
	  public ModelAndView viewRegistration()
	  {
	     return new ModelAndView("registration");
	  }
/*save new employee daTA*/
@RequestMapping("/saveContact")
	      public String saveEmployeeInoformation(@ModelAttribute Employee employee, BindingResult result)
	      {
		   
			iEmployeeService.addEmployee(employee);
			return "redirect:/index.htm";
		
	      }
/*delete employee record*/
@RequestMapping("/delete")
		public String deleteEmployee(@RequestParam int id) 
		{
	      System.out.println("id==="+id);
	       iEmployeeService.deleteEmployee(id);
			return "redirect:/index.html";
		}
/*Edit Page of Employee*/
@RequestMapping("/edit")
		public ModelAndView editPage(@RequestParam int id)
		{
			List<Employee> editlist=null;
	        System.out.println("Edit Page===="+id);
	       editlist= iEmployeeService.employeeEditService(id);
	        return new ModelAndView("edit","editlist",editlist);
		}
/*Update Page Of Employee*/
@RequestMapping("/update")
		public String updateEmployee(@ModelAttribute Employee employee)
		{
			
			iEmployeeService.updateEmployeeService(employee);
			return "redirect:/index.html";
	
		}


}


