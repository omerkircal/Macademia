package com.works;

import com.works.entities.Employee;
import com.works.repositories.EmployeeRepository;
import com.works.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class EmployeeServiceTest {



    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp(){
        employeeService=new EmployeeService(employeeRepository);
    }

    @Test
    void save(){
       Employee employee=new Employee(1l,"firstName1","lastName1",123123123l,"officeLocation1","department1",new BigDecimal(123123),new Date(),false);
         when(employeeRepository.save(employee)).thenReturn(employee);

         employeeService.save(employee);

    }

    @Test
    void update(){
       Employee employee=new Employee(1l,"firstName1","lastName1",123123123l,"officeLocation1","department1",new BigDecimal(123123),new Date(),false);
       lenient().when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);

       employeeService.update(employee);
    }

    @Test
    void delete(){

    }

    @Test
    void allEmployees(){

    }

    @Test
    void getEmployee(){

    }

    @Test
    void updateDepartmentOfficeLocation(){

    }
    @Test
    void getEmployeesByStartDateAndSalary(){

    }

    @Test
    void getWinner(){

    }

    @Test
    void completeDraw(){

    }


}
