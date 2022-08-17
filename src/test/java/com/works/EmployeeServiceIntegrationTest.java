package com.works;

import com.works.entities.Employee;
import com.works.repositories.EmployeeRepository;
import com.works.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class EmployeeServiceIntegrationTest {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void testSave(){
        Employee employee=new Employee(1l,"firstName1","lastName1",123123123l,"officeLocation1","department1",new BigDecimal(123123),new Date(),false);

        employeeService.save(employee);

        assertTrue(employee.getId()>0L);
    }

    @Test
    public void testUpdate(){
        Employee employee=new Employee(1l,"firstName1","lastName1",123123123l,"officeLocation1","department1",new BigDecimal(123123),new Date(),true);

        employeeService.update(employee);

        assertTrue(employee.getWinner()==true);
    }

    @Test
    public void testDelete(){
        Employee employee=new Employee(1l,"firstName1","lastName1",123123123l,"officeLocation1","department1",new BigDecimal(123123),new Date(),true);

        employeeService.delete(employee.getId());
        Optional<Employee> optionalEmployee=employeeRepository.findById(employee.getId());

        assertTrue(!optionalEmployee.isPresent());
    }

    @Test
    public void testAllEmployees(){
        List<Employee> employeeList=new ArrayList<>();
        Employee employee=new Employee(1l,"firstName1","lastName1",123123123l,"officeLocation1","department1",new BigDecimal(123123),new Date(),false);
        Employee employee1=new Employee(2l,"firstName2","lastName2",123123123l,"officeLocation1","department1",new BigDecimal(123123),new Date(),false);

        employeeList.add(employee);
        employeeList.add(employee1);


        assertTrue(employeeList.size()>1);
    }

    @Test
    public void testGetEmployee(){
        Employee employee=new Employee(1l,"firstName1","lastName1",123123123l,"officeLocation1","department1",new BigDecimal(123123),new Date(),false);

        employeeService.save(employee);

        Optional<Employee> optionalEmployee=employeeRepository.findById(employee.getId());

        assertTrue(optionalEmployee.isPresent());
    }

    @Test
    public void testUpdateDepartmentOfficeLocation(){
        Employee employee=new Employee(1l,"firstName1","lastName1",123123123l,"officeLocation1","department1",new BigDecimal(123123),new Date(),false);

        employeeRepository.updateOfficeLocationByDepartment(employee.getDepartment(),"İzmir");

        assertTrue(employee.getOfficeLocation().equals("İzmir"));
    }

    @Test
    public void testGetWinner(){
        Employee employee=new Employee(1l,"firstName1","lastName1",123123123l,"officeLocation1","department1",new BigDecimal(123123),new Date(),true);

        employeeService.getWinner();

        assertTrue(employee.getWinner()==true);
    }


}
