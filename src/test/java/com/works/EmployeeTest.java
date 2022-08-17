package com.works;

import com.works.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;

import static java.lang.Boolean.FALSE;
import static org.junit.jupiter.api.Assertions.*;

 class EmployeeTest {
    private static Employee employee;

    private static final Long ID=1L;
    private static final String FIRST_NAME="firstName";
    private static final String LAST_NAME="lastName";
    private static final Long IDENTIFICATION_NUMBER= 12345678902L;
    private static final String OFFICE_LOCATION = "officeLocation";
    private static final String DEPARTMENT = "department";
    private static final BigDecimal SALARY = BigDecimal.valueOf(30000);
    private static final Date START_DATE = new Date(System.currentTimeMillis());
    private static final Boolean WINNER = FALSE;

    @BeforeEach
    void setUp(){
        employee=new Employee();
    }

    @Test
    void testId(){
        employee.setId(ID);
        Long localID= employee.getId();

        assertEquals(ID,localID);
    }

    @Test
    void testFirstName(){
        employee.setFirstName(FIRST_NAME);
        String localFirstName=employee.getFirstName();

        assertEquals(FIRST_NAME,localFirstName);
    }

    @Test
    void testIdentificationNumber(){
        employee.setIdentificationNumber(IDENTIFICATION_NUMBER);
        Long localIdentificationNumber=employee.getIdentificationNumber();

        assertEquals(IDENTIFICATION_NUMBER,localIdentificationNumber);
    }

    @Test
    void testOfficeLocaliton(){
        employee.setOfficeLocation(OFFICE_LOCATION);
        String localOfficeLocation=employee.getOfficeLocation();

        assertEquals(OFFICE_LOCATION,localOfficeLocation);
    }

    @Test
    void testDepartment(){
        employee.setDepartment(DEPARTMENT);
        String localDepartment=employee.getDepartment();

        assertEquals(DEPARTMENT,localDepartment);
    }

    @Test
    void testSalary(){
        employee.setSalary(SALARY);
        BigDecimal localSalary=employee.getSalary();

        assertEquals(SALARY,localSalary);
    }

    @Test
    void testStartDate(){
        employee.setStartDate(START_DATE);
        Date localStartDate= (Date) employee.getStartDate();

         assertEquals(START_DATE,localStartDate);
    }

    @Test
    void testWinner(){
        employee.setWinner(WINNER);
        Boolean localWinner=employee.getWinner();

        assertEquals(WINNER,localWinner);
    }


}
