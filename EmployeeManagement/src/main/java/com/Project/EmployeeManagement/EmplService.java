package com.Project.EmployeeManagement;

import java.util.List;

import org.springframework.stereotype.Service;

public interface EmplService {

    String createEmployee(Employee employee);
    List<Employee> readEmployee();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id,Employee employee);
    Employee readEmploye(Long id);
    
}
