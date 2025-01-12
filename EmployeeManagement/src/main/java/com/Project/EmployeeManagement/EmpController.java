package com.Project.EmployeeManagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//This class is a Spring REST controller for managing Employee entities.


@RestController
@CrossOrigin("http://localhost:3000/")



public class EmpController {




  // Dependency injection for the Employee service

     // List<Employee> employees=new ArrayList<>();
     
  //  EmplService employeeService=new EmplServiceImpl();
    @Autowired
  //dependency injection
  EmplService employeeService;
 

  //to get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
       // List<Employee> employees=new ArrayList<>();
       //Employee emp=new Employee();
       //emp.setName("Janavi");
      // employees.add(emp);
        return employeeService.readEmployee();
    } 


    // to get single employee
     @GetMapping("employees/{id}")
    public Employee getAllEmployeesById(@PathVariable Long id){
       // List<Employee> employees=new ArrayList<>();
       //Employee emp=new Employee();
       //emp.setName("Janavi");
      // employees.add(emp);
        return employeeService.readEmploye(id);
    }
 


    //to add 
    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee){
       // employees.add(employee);
         return employeeService.createEmployee(employee);
        
    }


    //to delete
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id))
               return "delete Successsfully";
        return "not found";

    }
    //to update
    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id,@RequestBody Employee employee){


          return employeeService.updateEmployee(id, employee);
      
    }

    
}
