package com.Project.EmployeeManagement;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmplServiceImpl implements EmplService{

    @Autowired
    private EmplRepository employeeRepository;


   // List<Employee> employees=new ArrayList<>();
    @Override
    public String createEmployee(Employee employee) {
        // TODO Auto-generated method stub

        EmplEntity employeeEntity=new EmplEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);

      //   employees.add(employee);
         return "saved successfully";
       // throw new UnsupportedOperationException("Unimplemented method 'createEmployee'");
        
        

    }

    @Override
    public List<Employee> readEmployee() {
        // TODO Auto-generated method stub
        List<EmplEntity> employeeList=employeeRepository.findAll();
        List<Employee> employees=new ArrayList<>();
        for(EmplEntity employeeEntity:employeeList){
            Employee emp=new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
        return employees;
       // throw new UnsupportedOperationException("Unimplemented method 'readEmployee'");
    }

    @Override
    public boolean deleteEmployee(Long id) {
        // TODO Auto-generated method stub
        EmplEntity emp=employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
      //  employees.remove(id);
        return true;
        //throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        // TODO Auto-generated method stub
        EmplEntity existingEmployee=employeeRepository.findById(id).get();
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());

        employeeRepository.save(existingEmployee);
        return "update Successfully";
       // throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    @Override
    public Employee readEmploye(Long id) {
        // TODO Auto-generated method stub
       
        EmplEntity employeeEntity=employeeRepository.findById(id).get();

           Employee employee=new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        //throw new UnsupportedOperationException("Unimplemented method 'readEmploye'");

        return employee;
    }
    
}
