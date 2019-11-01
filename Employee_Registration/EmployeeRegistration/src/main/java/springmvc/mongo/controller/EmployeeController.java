package springmvc.mongo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.mongo.model.Employee;
import springmvc.mongo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private static Logger logger = Logger.getLogger(EmployeeController.class);
	 
    @Resource(name="employeeService")
    private EmployeeService employeeService;
 
    // Displaying the initial users list.
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getEmployessInfo(Model model) {
        logger.debug("Request to fetch all Employees from the mongo database");
        List employeeList = employeeService.getAllEmployee();      
        model.addAttribute("employees", employeeList);     
        return "employeeViewDetails";
    }
    
    // Opening the add new Employee form page.
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addEmployee(Model model) {
        logger.debug("Request to open the new Employee form page");
        model.addAttribute("empAttr",new Employee());
        return "employeeRegistrationForm";
    }
	
 // Opening the edit user form page.
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editEmployee(@RequestParam(value="emp_id", required=true) String emp_id, Model model) {
        logger.debug("Request to open the Edit employee form page");   
        model.addAttribute("empAttr",employeeService.findEmployeeById(emp_id));    
        return "employeeRegistrationForm";
    }
    
    // Deleting the specified Employee.
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam(value="emp_id", required=true) String emp_id, Model model) {
    	employeeService.delete(emp_id);
        return "redirect:view";
    }
    // Adding a new user or updating an existing user.
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("empAttr") Employee employee) {
        if(employee.getEmp_id() != null && !employee.getEmp_id().trim().equals("")) {
        	employeeService.edit(employee);
        } else {
        	employeeService.add(employee);
        }
        return "redirect:view";
    }
    
    
}
