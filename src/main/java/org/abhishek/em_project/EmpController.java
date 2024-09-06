package org.abhishek.em_project;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class EmpController {
    //List<Employee> employees= new ArrayList<>();
    @Autowired
    EmployeService employeeService = new EmployeeServiceImpl();

    @GetMapping("employee") 
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }


    @PostMapping("employee")
    public String createEmoloyee(@RequestBody Employee employee) {
        //employees.add(employee);
        employeeService.createEmployee(employee);
        return "Employee added successfully";
    }


    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        //employees.remove(id);
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
    
    
}
