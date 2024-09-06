package org.abhishek.em_project;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeService {

    List<Employee> employees = new ArrayList<>();
    @Override
    public String createEmployee(Employee employee) {
    if (employee.getId() == null) {
        employee.setId((long) (employees.size() + 1));
    }
    employees.add(employee);
    return "Employee added successfully";
}


    @Override
    public List<Employee> readEmployees() {
        return employees;
       
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return employees.removeIf(employee -> employee.getId().equals(id));
    }
}
