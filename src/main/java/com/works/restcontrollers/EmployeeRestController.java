package com.works.restcontrollers;

import com.works.entities.Employee;
import com.works.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
    final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long id){
        return employeeService.delete(id);
    }

    @GetMapping("/allEmployees")
    public ResponseEntity allEmployees(){
        return employeeService.allEmployees();
    }

    @GetMapping("/getEmployee")
    public ResponseEntity getEmployee(@RequestParam Long id){
        return employeeService.getEmployee(id);
    }

    @PutMapping("/updateDepartmentOfficeLocation")
    public ResponseEntity updateDepartmentOfficeLocation(@RequestParam String department,@RequestParam String location){
        return employeeService.updateDepartmentOfficeLocation(department,location);
    }

    @GetMapping("/employeesInfo")
    public ResponseEntity employeesInfo(@RequestParam Date date, @RequestParam BigDecimal salary){
        return employeeService.getEmployeesByStartDateAndSalary(date,salary);
    }

    @GetMapping("/winner")
    public ResponseEntity winner(){
        return employeeService.getWinner();
    }
}
