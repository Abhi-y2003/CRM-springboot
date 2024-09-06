package org.abhishek.em_project;

import java.util.List;

public interface EmployeService {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    
}
